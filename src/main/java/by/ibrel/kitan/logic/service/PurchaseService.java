package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.entity.Purchase;
import by.ibrel.kitan.logic.dao.repository.ClientRepository;
import by.ibrel.kitan.logic.dao.repository.PurchaseRepository;
import by.ibrel.kitan.logic.service.impl.IPurchaseService;
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

    //API

    @Override
    public Purchase createPurchase(final Client client) {
        final Purchase purchase = new Purchase();
        final Client clientAdd = clientRepository.findOne(client.getId());

        purchase.setNumberPurchase(getMaxValue());
        purchase.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        purchase.setClient(clientAdd);
        purchase.setPriceSummary(0);

        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> allPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public synchronized void sellProduct(final Purchase purchase, final Integer count) {
        Purchase entity = purchaseRepository.findOne(purchase.getId());

        Collection<Product> products = purchase.getProducts();

        for (Product product:products){

            product = productRepository.findOne(product.getId());

            if (product.isState()) {

                product.setState(false);
                product.setPurchase(entity);
                entity.setPriceSummary(entity.getPriceSummary()+SummaryPrice(product,count));
                product.setCount(product.getCount() - count);

            }else {

                //TODO show user message

                System.out.println("Product " + product.getNameProduct() + " occupied!");
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

    //get max value in table "purchase", for find max value == number purchase
    protected Integer getMaxValue(){
        if(purchaseRepository.findMaxValue()!=null) {
            final Purchase purchase = purchaseRepository.findMaxValue();
            int i = purchase.getNumberPurchase();
            return ++i;
        }else {
            return 1;
        }
    }

    //calculating summary price
    protected int SummaryPrice(Product product, final int count){
        int sum = 0;
        sum += product.getPrice().getByRuble()*count;
        return sum;
    }
}
