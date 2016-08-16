package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.beans.Status;
import by.ibrel.kitan.logic.dao.entity.*;
import by.ibrel.kitan.logic.dao.repository.ShoppingCartRepository;
import by.ibrel.kitan.logic.service.impl.IClientService;
import by.ibrel.kitan.logic.service.impl.IProductService;
import by.ibrel.kitan.logic.service.impl.IPurchaseHistoryService;
import by.ibrel.kitan.logic.service.impl.IShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

import static by.ibrel.kitan.logic.Const.START_NUMBER;

/**
 * @author ibrel
 * @version 1.2 (28.07.2016)
 */

@Service
@Transactional
public class ShoppingCartService implements IShoppingCartService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    //API

    @Override
    public ShoppingCart createCart(final Long clientId) {

        ShoppingCart shoppingCart = new ShoppingCart();
        final Client clientAdd = clientService.findOne(clientId);

        shoppingCart.setNumberCart(getMaxValue());
        shoppingCart.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        shoppingCart.setClient(clientAdd);
        shoppingCart.setPriceSummary(0.0);
        shoppingCart.setQuantity(0);
        shoppingCart.setStatus(Status.CREATE);

        save(shoppingCart);
        return shoppingCart;
    }

    @Override
    public ShoppingCart findCartWithClient(Long id) {
        return shoppingCartRepository.findShoppingCartWithClient(id);
    }

    @Override
    public synchronized void sellProduct(final ShoppingCart shoppingCart, final Integer quantity) throws Exception {

        ShoppingCart entity = shoppingCartRepository.findOne(shoppingCart.getId());

        Collection<Product> p = entity.getProducts();

        Product productForHistory = null;

        for (Product product: shoppingCart.getProducts()){

            product = productService.findOne(product.getId());

            if (quantity>0 && quantity<=product.getQuantity()) {
                if (!p.contains(product)) {
                    p.add(product);
                }
                entity.setPriceSummary(entity.getPriceSummary()+SummaryPrice(product,quantity, entity.getClient().getDiscountPrice()));
                entity.setQuantity(entity.getQuantity()+quantity);

                product.setQuantity(product.getQuantity() - quantity);
                productService.save(product);

                productForHistory = product;

            }else {
                System.err.println("Purchase quantity > product quantity and > 0");
                //TODO info client that quantity <0
            }
        }

        entity.setProducts(p);
        entity.setStatus(Status.FORMING);

        save(entity);

        purchaseHistoryService.createPurchaseHistory(entity,productForHistory,quantity);
    }

    @Override
    public synchronized void save(ShoppingCart entity) {
        shoppingCartRepository.saveAndFlush(entity);
    }

    @Override
    public synchronized void delete(Long id) {
        emptyCart(id);
        shoppingCartRepository.delete(id);
    }

    @Override
    public synchronized void update(ShoppingCart shoppingCart) {
        ShoppingCart entity = findOne(shoppingCart.getId());
        if (entity!=null){

        }
        shoppingCartRepository.saveAndFlush(entity);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart findOne(Long id) {
        return shoppingCartRepository.findOne(id);
    }

    @Override
    public synchronized void changeStatus(Long id) {
       findOne(id).setStatus(Status.FORMED);
    }

    @Override
    public synchronized void deleteProductFromCart(Long cartId, Long histId, Long productId) {

        ShoppingCart shoppingCart = findOne(cartId);
        PurchaseHistory purchaseHistory = purchaseHistoryService.findOne(histId);
        Product product = productService.findOne(productId);

        List<Product> products = (List<Product>) shoppingCart.getProducts();
        ListIterator<Product> iterator = products.listIterator();

      while (iterator.hasNext()){
          if (iterator.next().getId().equals(productId)){
              iterator.remove();
          }
      }
        //TODO это полный зашквар, вынести всё в методы!
        //set quantity for cart
        shoppingCart.setQuantity(shoppingCart.getQuantity()-purchaseHistory.getQuantity());
        //set price for cart
        shoppingCart.setPriceSummary(shoppingCart.getPriceSummary()-
                (purchaseHistory.getQuantity()*
                        (purchaseHistory.getProduct().getPrice()-((purchaseHistory.getProduct().getPrice()*
                                purchaseHistory.getClient().getDiscountPrice())/100))));
        //set quantity for product
        product.setQuantity(product.getQuantity()+purchaseHistory.getQuantity());
        //delete history
        purchaseHistoryService.delete(purchaseHistory.getId());
    }

    @Override
    public Integer findMaxValue() {
        return shoppingCartRepository.findMaxValue();
    }

    /**
     * get max value in table "purchase", for find max value == number purchase
     *
     * @return value
     */
    protected Integer getMaxValue(){
        if(findMaxValue()!= null) {
            Integer i = findMaxValue();
            return ++i;
        }else {
            return START_NUMBER;
        }
    }

    /**
     * Calculating summary price with discount
     *
     * @param product object product
     * @param quantity entering quantity products
     * @param discount Client personal discount
     * @return summary price
     */
    private double SummaryPrice(Product product, final double quantity, final double discount){
        double sum = 0;

        //discount
        sum += ((product.getPrice())-(product.getPrice()*discount/100))*quantity;
        return sum;
    }


    /**
     * Removed all reference on object Cart
     *
     * @param id shopping cart id
     */
    private void emptyCart(final Long id){

        ShoppingCart shoppingCart = findOne(id);

        List<PurchaseHistory> list = purchaseHistoryService.findAll();

        for (PurchaseHistory purchaseHistory:list){
            if (Objects.equals(purchaseHistory.getShoppingCart().getId(), id)){
                if(shoppingCart.getStatus()==Status.FORMING){

                    //return quantity to product if status FORMING
                    purchaseHistory.getProduct().setQuantity(purchaseHistory.getQuantity()+purchaseHistory.getProduct().getQuantity());
                }
                purchaseHistoryService.delete(purchaseHistory.getId());
            }
        }

        if (shoppingCart!=null){
            shoppingCart.getProducts().clear();
        }
    }
}