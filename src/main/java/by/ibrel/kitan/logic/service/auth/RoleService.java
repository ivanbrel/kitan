package by.ibrel.kitan.logic.service.auth;


import by.ibrel.kitan.logic.dao.auth.entity.Role;
import by.ibrel.kitan.logic.dao.auth.repository.RoleRepository;
import by.ibrel.kitan.logic.exception.auth.RoleExistsException;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.dao.auth.entity.dto.RoleDto;
import by.ibrel.kitan.logic.service.auth.impl.IPrivilegeService;
import by.ibrel.kitan.logic.service.auth.impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void update(RoleDto roleDto) {
        Role entity = findOne(roleDto.getId());

        if(roleDto.getPrivileges()!=null) {
            entity.getPrivileges().clear();
            roleDto.getPrivileges().forEach(privilege -> entity.addPrivilege(privilegeService.findByName(privilege)));
        }else {
            entity.getPrivileges().clear();
        }
        save(entity);
    }

    @Override
    @Transactional
    public void update(Role role) {
        Role entity = findByName(role.getName());

        if(role.getPrivileges()!=null) {
            entity.getPrivileges().clear();
            role.getPrivileges().forEach(privilege -> entity.addPrivilege(privilegeService.findByName(privilege.getName())));
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
