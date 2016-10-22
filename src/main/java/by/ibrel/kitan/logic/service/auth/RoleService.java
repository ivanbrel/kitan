package by.ibrel.kitan.logic.service.auth;


import by.ibrel.kitan.logic.dao.auth.entity.Privilege;
import by.ibrel.kitan.logic.dao.auth.entity.Role;
import by.ibrel.kitan.logic.dao.auth.repository.RoleRepository;
import by.ibrel.kitan.logic.exception.auth.RoleExistsException;
import by.ibrel.kitan.logic.service.auth.dto.RoleDto;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.auth.impl.IPrivilegeService;
import by.ibrel.kitan.logic.service.auth.impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;

/**
 * @author ibrel
 * @version 1.1 (08.04.2016)
 */

@Service
public class RoleService extends AbstractService<Role> implements IRoleService {

    private RoleRepository repository;
    private IPrivilegeService privilegeService;

    @Autowired
    public RoleService(final RoleRepository repository, final IPrivilegeService privilegeService) {
        super(repository);
        this.repository = repository;
        this.privilegeService = privilegeService;
    }

    //API

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

    public Role findByName(final String name) {
        return repository.findByName(name);
    }

    @Transactional
    public void emptyRole(final Long id){
        final Role entity = findOne(id);
        if (entity.getPrivileges()!=null) {
            entity.getPrivileges().clear();
        }
    }

    @Override
    @Transactional
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
    @Transactional
    public Role create(Object o) {

        RoleDto roleDto = (RoleDto) o;

        if(roleExist(roleDto.getName())){
            try {
                throw new RoleExistsException("Role with name " + roleDto.getName() + " exist");
            } catch (RoleExistsException e) {
                e.printStackTrace();
            }
        }
        final Role role = new Role();
        role.setName(roleDto.getName());
        save(role);
        return role;
    }
}
