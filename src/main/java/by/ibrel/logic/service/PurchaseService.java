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

import java.util.Collection;

@Service
@Transactional
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Purchase createPurchase(PurchaseDto purchaseDto) {
        final Purchase purchase = new Purchase();
        final Client client = clientRepository.findOne(purchaseDto.getClientId());
//        final Product product = productRepository.findOne(purchaseDto.getProductId());
//
//
//        Collection<Product> products = new Purchase().getProduct();
//        products.add(product);

        purchase.setNumberPurchase(getMaxValue());
        purchase.setDate(purchaseDto.getDate());
        purchase.setClient(client);
        purchase.setProduct(null);

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
    public Collection<Purchase> allPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public synchronized Client addClient(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public synchronized Product addProduct(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public synchronized void sellProduct() {

    }

    @Override
    public void delete(Long id) {
        purchaseRepository.delete(id);
    }
}
