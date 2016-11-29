package by.ibrel.kitan.logic.service.auth.impl;

import by.ibrel.kitan.logic.dao.auth.entity.Role;
import by.ibrel.kitan.logic.service.ICommonService;
import by.ibrel.kitan.logic.service.auth.dto.RoleDto;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IRoleService extends ICommonService<Role>{

    Role findByName(final String name);

    void emptyRole(final Long id);

    void update(RoleDto roleDto);
}
