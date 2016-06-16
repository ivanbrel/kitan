package by.ibrel.logic.service;

import by.ibrel.logic.entity.Client;
import by.ibrel.logic.entity.Product;
import by.ibrel.logic.entity.Purchase;
import by.ibrel.logic.repository.ClientRepository;
import by.ibrel.logic.repository.ProductRepository;
import by.ibrel.logic.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    //create purchase without adding client
    @Override
    public Purchase createPurchase(final Client client) {
        final Purchase purchase = new Purchase();
        final Client clientAdd = clientRepository.findOne(client.getId());

        purchase.setNumberPurchase(getMaxValue());
        purchase.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        purchase.setClient(clientAdd);

        return purchaseRepository.save(purchase);
    }

    Integer getMaxValue(){
        if(purchaseRepository.findMaxValue()!=null) {
            final Purchase purchase = purchaseRepository.findMaxValue();
            Integer i = purchase.getNumberPurchase();
            return ++i;
        }else {
            return 1;
        }
    }

    @Override
    public List<Purchase> allPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public synchronized Client addClient(final Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public synchronized Product addProduct(final Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public synchronized void sellProduct(final Purchase purchase) {
        Purchase entity = purchaseRepository.findOne(purchase.getId());

        Collection<Product> products = purchase.getProducts();
        for (Product product:products){
            product = productRepository.findOne(product.getId());
            if (product.isState()) {
                product.setState(false);
                product.setPurchase(entity);
            }
        }
        purchaseRepository.save(entity);
    }

    @Override
    public synchronized void delete(Long id) {
        Purchase entity = purchaseRepository.findOne(id);

        if (entity.getProducts()==null){
            purchaseRepository.delete(id);
        }else {
            Collection<Product> products = entity.getProducts();
            for (Product product : products) {
                product = productRepository.findOne(product.getId());
                product.setState(true);
                product.setPurchase(null);
            }
            purchaseRepository.save(entity);
            purchaseRepository.delete(id);
        }

    }
}
