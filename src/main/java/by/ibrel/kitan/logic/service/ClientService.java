package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.dao.repository.ClientRepository;
import by.ibrel.kitan.logic.exception.ClientExistsException;
import by.ibrel.kitan.logic.service.dto.ClientDto;
import by.ibrel.kitan.logic.service.impl.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService implements IClientService{

    /**
     *dependence problem clientRepository !
     */

    @Autowired
    private ClientRepository repository;

    //API

    @Override
    public Client createClient(ClientDto clientDto) throws ClientExistsException {
        if(clientExists(clientDto.getAccount())){
            throw new ClientExistsException("Client with last name " + clientDto.getLastName() + " and number account "
            + clientDto.getAccount() + " already exists");
        }

        final Client client = new Client();

        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAccount(clientDto.getAccount());

        //TODO check value
        client.setDiscountPrice(Double.parseDouble(clientDto.getDiscount()));

        return repository.save(client);
    }

    private boolean clientExists(final String account) {
        final Client client = repository.findByAccount(account);
        return client != null;
    }

    @Override
    public void saveNewClient(Client client) {
        repository.save(client);
    }

    @Override
    public Client getClient(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Client findByNameClient(String nameClient) {
        return repository.findByLastName(nameClient);
    }

    @Override
    public Client findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Client> findAllClient() {
        return repository.findAll();
    }

    @Override
    public void updateClient(Client client) {
        Client entity = repository.findByAccount(client.getAccount());
        if(entity!=null){
            entity.setFirstName(client.getFirstName());
            entity.setLastName(client.getLastName());
            entity.setPhone(client.getPhone());
            entity.setEmail(client.getEmail());
        }
        repository.save(entity);
    }

    @Override
    public void deleteClient(Long id) {
        repository.delete(id);
    }

}
