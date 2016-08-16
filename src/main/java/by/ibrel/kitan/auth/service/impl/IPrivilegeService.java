package by.ibrel.kitan.auth.service.impl;

import by.ibrel.kitan.auth.dao.entity.Privilege;

/**
 * @author ibrel
 * @version 1.0 (12.08.2016)
 */
public interface IPrivilegeService extends ICommonService<Privilege> {

    Privilege findByName(String name);
}
