package by.ibrel.kitan.auth.service.impl;

import by.ibrel.kitan.auth.dao.entity.Privilege;
import by.ibrel.kitan.auth.dao.entity.Role;
import by.ibrel.kitan.auth.exception.RoleExistsException;
import by.ibrel.kitan.auth.service.dto.RoleDto;


import java.util.List;

public interface IRoleService {

    Role addNewRole(RoleDto roleDto) throws RoleExistsException;

    Role findByName(String name);

    List<Role> findAllRoles();

    void editRole(Role role);

    void deleteRole(Long id);

    List<Privilege> getAllPrivileges();

    void emptyRole(final Long id);
}
