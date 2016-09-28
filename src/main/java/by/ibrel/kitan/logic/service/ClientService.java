package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Address;
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

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ibrel
 * @version 1.2 (13.05.2016)
 */


@Service
@Transactional
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository repository;

    //API

    @Override
    public Client createClient(ClientDto clientDto) throws ClientExistsException {

        if(clientExists(clientDto.getAccount())){
            throw new ClientExistsException("Client with last name " + clientDto.getLastName() + " and number account "
            + clientDto.getAccount() + " already exists");
        }

//        final Address address = new Address(clientDto.getCountry(),clientDto.getTown(),clientDto.getStreet(),clientDto.getPostCode());


        final Client client = new Client(clientDto.getFirstName(),clientDto.getLastName(),clientDto.getEmail(),clientDto.getPhone(),
                clientDto.getAccount(), null, new BigDecimal(clientDto.getDiscount()));
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
        return findByAccountClient(account) != null;
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
        repository.delete(id);
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
            entity.setAddress(client.getAddress());
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
