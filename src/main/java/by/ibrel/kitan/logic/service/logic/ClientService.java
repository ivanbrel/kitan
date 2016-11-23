package by.ibrel.kitan.logic.service.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Client;
import by.ibrel.kitan.logic.dao.logic.repository.ClientRepository;
import by.ibrel.kitan.logic.exception.logic.ClientExistsException;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.logic.dto.ClientDto;
import by.ibrel.kitan.logic.service.logic.impl.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ibrel
 * @version 1.2 (13.05.2016)
 */


@Service
public class ClientService extends AbstractService<Client> implements IClientService {

    private ClientRepository repository;

    @Autowired
    public ClientService(final ClientRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //API

    public Client findByNameClient(String nameClient) {
        return repository.findByName(nameClient);
    }

    @Override
    @Transactional
    public Client create(Object o) {
        ClientDto clientDto = (ClientDto) o;
        if(clientExists(clientDto.getName())){
            throw new ClientExistsException("Client with name " + clientDto.getName() + " already exists");
        }

        final Client client = new Client(clientDto);
        save(client);
        return client;
    }

    /**
     * Check exists account
     *
     * @param name client account
     * @return true if account exists
     */
    private boolean clientExists(final String name) {
        return findByNameClient(name) != null;
    }
}
