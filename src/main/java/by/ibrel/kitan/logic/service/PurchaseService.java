package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.*;
import by.ibrel.kitan.logic.dao.repository.InfoPurchaseProductRepository;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.repository.ClientRepository;
import by.ibrel.kitan.logic.dao.repository.PurchaseRepository;
import by.ibrel.kitan.logic.service.impl.IPurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static by.ibrel.kitan.logic.Const.START_NUMBER;


@Service
@Transactional
public class PurchaseService implements IPurchaseService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

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

        purchaseRepository.save(purchase);

        return purchase;
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

            if (count<product.getCount()) {
                p.add(product);

                entity.setPriceSummary(entity.getPriceSummary()+SummaryPrice(product,count, entity.getClient().getDiscountPrice()));
                entity.setCountSummary(entity.getCountSummary()+infoCount(entity,product,count));


                product.setCount(product.getCount() - count);
                productRepository.save(product);

            }else LOGGER.debug("Purchase count > product count");{

                //TODO info client that count <0

            }
        }

        entity.setProducts(p);

        purchaseRepository.save(entity);
    }

    @Override
    public synchronized void delete(Long id) {
        Purchase entity = purchaseRepository.findOne(id);

//        entity.getProducts().clear();
//        entity.getInfoPurchaseProducts().clear();
        purchaseRepository.delete(entity);
    }

    //get max value in table "purchase", for find max value == number purchase
    protected Integer getMaxValue(){
        if(purchaseRepository.findMaxValue()!= null) {
            Integer i = purchaseRepository.findMaxValue();
            return ++i;
        }else {
            return START_NUMBER;
        }
    }

    //calculating summary price
    private double SummaryPrice(Product product, final double count, final double discount){
        double sum = 0;

        //discount
        sum += ((product.getPrice())-(product.getPrice()*discount/100))*count;
        return sum;
    }

    private int infoCount(final Purchase purchase, final Product product, final Integer count){

        InfoPurchaseProduct infoPurchaseProduct = new InfoPurchaseProduct();
        infoPurchaseProduct.setPurchase(purchase);
        infoPurchaseProduct.setProduct(product);
        infoPurchaseProduct.setCount(count);
        infoPurchaseProduct.setNumberPurchase(purchase.getNumberPurchase());

        infoPurchaseProduct.setPrice(product.getPrice());

        infoPurchaseProductRepository.save(infoPurchaseProduct);
        return count;
    }

}
