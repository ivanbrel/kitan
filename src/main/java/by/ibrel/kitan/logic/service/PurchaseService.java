package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.*;
import by.ibrel.kitan.logic.dao.repository.InfoPurchaseProductRepository;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.repository.ClientRepository;
import by.ibrel.kitan.logic.dao.repository.PurchaseRepository;
import by.ibrel.kitan.logic.service.impl.IPurchaseService;
import by.ibrel.kitan.web.controllers.ExceptionHandlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
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

    @Autowired
    private InfoPurchaseProductRepository infoPurchaseProductRepository;

    //API

    @Override
    public Purchase createPurchase(final Client client) {
        final Purchase purchase = new Purchase();
        final Client clientAdd = clientRepository.findOne(client.getId());

        purchase.setNumberPurchase(getMaxValue());
        purchase.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        purchase.setClient(clientAdd);
        purchase.setPriceSummary(0.0);
        purchase.setCountSummary(0);

        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> allPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public synchronized void sellProduct(final Purchase purchase, final Integer count) throws Exception {
        Purchase entity = purchaseRepository.findOne(purchase.getId());

        //Collection<Product> products = purchase.getProducts();

        Collection<Product> p = entity.getProducts();

        for (Product product:purchase.getProducts()){

            product = productRepository.findOne(product.getId());

            p.add(product);

            entity.setPriceSummary(entity.getPriceSummary()+SummaryPrice(product,count));
            entity.setCountSummary(entity.getCountSummary()+infoCount(entity,product,count));

            if (product.getCount()>0) {
                product.setCount(product.getCount() - count);
            }else{
                //TODO info client that count <0
                throw new Exception();
            }

        }

        entity.setProducts(p);

        purchaseRepository.save(entity);
    }

    @Override
    public synchronized void delete(Long id) {
        Purchase entity = purchaseRepository.findOne(id);

        entity.getProducts().clear();
        entity.getInfoPurchaseProducts().clear();
        purchaseRepository.delete(entity);
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
    protected double SummaryPrice(Product product, final double count){
        double sum = 0;
        sum += product.getPrice().getByRuble()*count;
        return sum;
    }

    protected int infoCount(final Purchase purchase, final Product product, final Integer count){

        InfoPurchaseProduct infoPurchaseProduct = new InfoPurchaseProduct();
        infoPurchaseProduct.setPurchase(purchase);
        infoPurchaseProduct.setProduct(product);
        infoPurchaseProduct.setCount(count);

        //ruble!!!!
        infoPurchaseProduct.setPrice(product.getPrice().getByRuble());

        infoPurchaseProductRepository.save(infoPurchaseProduct);
        return count;
    }
}
