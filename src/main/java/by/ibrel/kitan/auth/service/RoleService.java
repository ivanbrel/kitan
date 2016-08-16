package by.ibrel.kitan.auth.service;


import by.ibrel.kitan.auth.dao.entity.Privilege;
import by.ibrel.kitan.auth.dao.entity.Role;
import by.ibrel.kitan.auth.dao.repository.RoleRepository;
import by.ibrel.kitan.auth.exception.RoleExistsException;
import by.ibrel.kitan.auth.service.dto.RoleDto;
import by.ibrel.kitan.auth.service.impl.IPrivilegeService;
import by.ibrel.kitan.auth.service.impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;

/**
 * @author ibrel
 * @version 1.1 (08.04.2016)
 */

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private IPrivilegeService privilegeService;

    //API

    @Override
    public Role addNewRole(final RoleDto roleDto) throws RoleExistsException {
        if(roleExist(roleDto.getName())){
            throw new RoleExistsException("Role with name " + roleDto.getName() + " exist");
        }
        final Role role = new Role();
        role.setName(roleDto.getName());
        save(role);
        return role;
    }

    /**
     * Check exist role
     *
     * @param name name role
     * @return true - role exist
     */
    private boolean roleExist(final String name) {
        final Role role = repository.findByName(name);
        return role!=null;
    }

    @Override
    public Role findByName(final String name) {
        return repository.findByName(name);
    }

    @Override
    public void emptyRole(final Long id){
        final Role entity = findOne(id);
        if (entity.getPrivileges()!=null) {
            entity.getPrivileges().clear();
        }
    }

    @Override
    public void save(Role entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(Role role) {
        Role entity = findByName(role.getName());

        Collection<Privilege> privileges = role.getPrivileges();

        if(privileges!=null) {
            Collection<Privilege> p = entity.getPrivileges();
            entity.getPrivileges().clear();
            for (Privilege privilege : role.getPrivileges()) {
                privilege = privilegeService.findByName(privilege.getName());
//                if (!p.contains(privilege)) {
                p.add(privilege);
//                }
            }
            entity.setPrivileges(p);
        }else {
            entity.getPrivileges().clear();
        }

        save(entity);

    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return repository.findOne(id);
    }
}
