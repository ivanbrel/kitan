package by.ibrel.logic.service;

import by.ibrel.logic.entity.Client;
import by.ibrel.logic.exception.ClientExistsException;
import by.ibrel.logic.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService implements IClientService {

    /**
     *dependence problem clientRepository !
     */

    @Autowired
    private ClientRepository clientRepository;

    //API

    @Override
    public Client createClient(ClientDto clientDto) throws ClientExistsException {
        if(clientExists(clientDto.getLastName(), clientDto.getAccount())){
            throw new ClientExistsException("Client with last name " + clientDto.getLastName() + " and number account "
            + clientDto.getAccount() + " already exists");
        }

        final Client client = new Client();

        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAccount(clientDto.getAccount());
        return clientRepository.save(client);
    }

    private boolean clientExists(final String lastName, final String account) {
        final Client client = clientRepository.findByLastName(lastName);
        final Client client2 = clientRepository.findByAccount(account);
        return client != null && client2 != null;
    }

    @Override
    public void saveNewClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client findByNameClient(String nameClient) {
        return clientRepository.findByLastName(nameClient);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void updateClient(Client client) {
        Client entity = clientRepository.findByAccount(client.getAccount());
        if(entity!=null){
            entity.setFirstName(client.getFirstName());
            entity.setLastName(client.getLastName());
            entity.setPhone(client.getPhone());
            entity.setEmail(client.getEmail());
        }
        clientRepository.save(entity);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(id);
    }
}
