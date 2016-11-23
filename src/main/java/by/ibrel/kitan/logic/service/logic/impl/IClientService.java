package by.ibrel.kitan.logic.service.logic.impl;

import by.ibrel.kitan.logic.dao.logic.entity.Client;
import by.ibrel.kitan.logic.service.ICommonService;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IClientService extends ICommonService<Client> {

    Client findByNameClient(String nameClient);
}
