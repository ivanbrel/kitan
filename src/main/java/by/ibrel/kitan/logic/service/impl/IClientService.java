package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.exception.ClientExistsException;
import by.ibrel.kitan.logic.service.dto.ClientDto;

import java.util.List;

/**
 * Created by ibrel on 13/05/16.
 */
public interface IClientService {

    Client createClient(ClientDto clientDto) throws ClientExistsException;

    void saveNewClient(Client client);

    Client getClient(Long id);

    Client findByNameClient(String nameClient);

    Client findById(Long id);

    List<Client> findAllClient();

    void updateClient(Client client);

    void deleteClient(Long id);
}
