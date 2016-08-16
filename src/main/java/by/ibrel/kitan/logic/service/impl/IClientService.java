package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.auth.service.impl.ICommonService;
import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.exception.ClientExistsException;
import by.ibrel.kitan.logic.service.dto.ClientDto;

/**
 * @author ibrel
 * @version 1.1 (13.05.2016)
 */
public interface IClientService extends ICommonService<Client>{

    Client createClient(ClientDto clientDto) throws ClientExistsException;

    Client findByNameClient(String nameClient);

    Client findByAccountClient(String account);
}
