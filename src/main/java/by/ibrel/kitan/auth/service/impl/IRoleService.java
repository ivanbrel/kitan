package by.ibrel.kitan.auth.service.impl;


import by.ibrel.kitan.auth.dao.entity.Role;
import by.ibrel.kitan.auth.exception.RoleExistsException;
import by.ibrel.kitan.auth.service.dto.RoleDto;

/**
 * @author ibrel
 * @version 1.1 (12.08.2016)
 */

public interface IRoleService extends ICommonService<Role>{

    Role addNewRole(RoleDto roleDto) throws RoleExistsException;

    Role findByName(String name);

    /**
     * Removes all references to objects invoking to this object
     *
     * @param id role id
     */
    void emptyRole(final Long id);
}
