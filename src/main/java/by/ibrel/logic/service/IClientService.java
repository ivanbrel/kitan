package by.ibrel.logic.service;

import by.ibrel.logic.entity.Client;
import by.ibrel.logic.exception.ClientExistsException;

import java.util.List;

/**
 * Created by ibrel on 13/05/16.
 */
public interface IClientService {

    Client createClient(ClientDto clientDto) throws ClientExistsException;

    void saveNewClient(Client client);

    Client getClient(Long id);

    Client findByNameClient(String nameClient);

    List<Client> findAllClient();

    void updateClient(Client client);

    void deleteClient(Long id);
}
