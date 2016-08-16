package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.dao.repository.ClientRepository;
import by.ibrel.kitan.logic.dao.repository.ShoppingCartRepository;
import by.ibrel.kitan.logic.exception.ClientExistsException;
import by.ibrel.kitan.logic.service.dto.ClientDto;
import by.ibrel.kitan.logic.service.impl.IClientService;
import by.ibrel.kitan.logic.service.impl.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ibrel
 * @version 1.1 (13.05.2016)
 */


@Service
@Transactional
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository repository;

    @Autowired
    private IShoppingCartService cartService;

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

        save(client);
        return client;
    }

    /**
     * Check exists account
     *
     * @param account client account
     * @return true if account exists
     */
    private boolean clientExists(final String account) {
        final Client client = findByAccountClient(account);
        return client != null;
    }


    @Override
    public Client findByNameClient(String nameClient) {
        return repository.findByLastName(nameClient);
    }

    @Override
    public Client findByAccountClient(String account) {
        return repository.findByAccount(account);
    }

    @Override
    public void save(Client entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        if (cartService.findCartWithClient(id)==null){
            repository.delete(id);
        }
    }

    @Override
    public void update(Client client) {

        Client entity = findByAccountClient(client.getAccount());
        if(entity!=null){
            entity.setFirstName(client.getFirstName());
            entity.setLastName(client.getLastName());
            entity.setPhone(client.getPhone());
            entity.setEmail(client.getEmail());
            entity.setDiscountPrice(client.getDiscountPrice());
            entity.setAccount(client.getAccount());
        }
        save(entity);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findOne(Long id) {
        return repository.findOne(id);
    }
}
