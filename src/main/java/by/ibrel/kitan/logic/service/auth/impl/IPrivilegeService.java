package by.ibrel.kitan.logic.service.auth.impl;

import by.ibrel.kitan.logic.dao.auth.entity.Privilege;
import by.ibrel.kitan.logic.service.ICommonService;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IPrivilegeService extends ICommonService<Privilege> {

    Privilege findByName(String name);
}
