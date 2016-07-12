package by.ibrel.kitan.auth.service;


import by.ibrel.kitan.auth.dao.entity.Privilege;
import by.ibrel.kitan.auth.dao.entity.Role;
import by.ibrel.kitan.auth.dao.repository.PrivilegeRepository;
import by.ibrel.kitan.auth.dao.repository.RoleRepository;
import by.ibrel.kitan.auth.exception.RoleExistsException;
import by.ibrel.kitan.auth.service.dto.RoleDto;
import by.ibrel.kitan.auth.service.impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public Role addNewRole(final RoleDto roleDto) throws RoleExistsException {
        if(roleExist(roleDto.getName())){
            throw new RoleExistsException("Role with name " + roleDto.getName() + " exist");
        }
        final Role role = new Role();
        role.setName(roleDto.getName());
        return repository.save(role);
    }

    private boolean roleExist(final String name) {
        final Role role = repository.findByName(name);
        return role!=null;
    }

    @Override
    public Role findByName(final String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Role> findAllRoles() {
        return repository.findAll();
    }


    @Override
    public void editRole(final Role role) {

        Role entity = findByName(role.getName());

        Collection<Privilege> privileges = role.getPrivileges();

        if(privileges!=null) {
            Collection<Privilege> p = entity.getPrivileges();
            entity.getPrivileges().clear();
            for (Privilege privilege : role.getPrivileges()) {
                privilege = privilegeRepository.findByName(privilege.getName());
//                if (!p.contains(privilege)) {
                    p.add(privilege);
//                }
            }
            entity.setPrivileges(p);
        }else {
            entity.getPrivileges().clear();
        }

        repository.save(entity);
    }

    @Override
    public void deleteRole(final Long id) {
        repository.delete(id);
    }

    @Override
    public void emptyRole(final Long id){
        final Role entity = repository.findOne(id);
        if (entity.getPrivileges()!=null) {
            entity.getPrivileges().clear();
        }
    }


    @Override
    public List<Privilege> getAllPrivileges(){
        return privilegeRepository.findAll();
    }
}
