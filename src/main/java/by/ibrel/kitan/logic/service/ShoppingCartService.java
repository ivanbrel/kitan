package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.beans.Status;
import by.ibrel.kitan.logic.dao.entity.*;
import by.ibrel.kitan.logic.dao.repository.PurchaseHistoryRepository;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.repository.ClientRepository;
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
        final Client clientAdd = clientService.getClient(clientId);

        shoppingCart.setNumberCart(getMaxValue());
        shoppingCart.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        shoppingCart.setClient(clientAdd);
        shoppingCart.setPriceSummary(0.0);
        shoppingCart.setQuantity(0);
        shoppingCart.setStatus(Status.CREATE);

        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @Override
    public List<ShoppingCart> allCart() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public synchronized void sellProduct(final ShoppingCart shoppingCart, final Integer quantity) throws Exception {

        ShoppingCart entity = shoppingCartRepository.findOne(shoppingCart.getId());

        Collection<Product> p = entity.getProducts();

        Product productForHistory = null;

        for (Product product: shoppingCart.getProducts()){

            product = productService.getProduct(product.getId());

            if (quantity>0 && quantity<=product.getQuantity()) {
                if (!p.contains(product)) {
                    p.add(product);
                }
                entity.setPriceSummary(entity.getPriceSummary()+SummaryPrice(product,quantity, entity.getClient().getDiscountPrice()));
                entity.setQuantity(entity.getQuantity()+quantity);

                product.setQuantity(product.getQuantity() - quantity);
                productService.saveProduct(product);

                productForHistory = product;

            }else {
                System.err.println("Purchase quantity > product quantity and > 0");
                //TODO info client that quantity <0
            }
        }

        entity.setProducts(p);
        entity.setStatus(Status.FORMING);

        shoppingCartRepository.save(entity);

        purchaseHistoryService.createPurchaseHistory(entity,productForHistory,quantity);
    }

    @Override
    public synchronized void delete(Long id) {
        emptyCart(id);
        shoppingCartRepository.delete(id);
    }

    @Override
    public ShoppingCart getCartById(Long id) {
        return shoppingCartRepository.findOne(id);
    }

    @Override
    public void changeStatus(Long id) {
        shoppingCartRepository.findOne(id).setStatus(Status.FORMED);
    }

    @Override
    public void editCart(ShoppingCart shoppingCart) {

        ShoppingCart entity = getCartById(shoppingCart.getId());
        if (entity!=null){

        }
        shoppingCartRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteProductFromCart(Long cartId, Long histId, Long productId) {

        ShoppingCart shoppingCart = getCartById(cartId);
        PurchaseHistory purchaseHistory = purchaseHistoryService.getPurchaseHistory(histId);
        Product product = productService.getProduct(productId);

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
        purchaseHistoryService.deletePurchaseHistory(purchaseHistory.getId());
    }

    //get max value in table "purchase", for find max value == number purchase
    protected Integer getMaxValue(){
        if(shoppingCartRepository.findMaxValue()!= null) {
            Integer i = shoppingCartRepository.findMaxValue();
            return ++i;
        }else {
            return START_NUMBER;
        }
    }

    //calculating summary price
    private double SummaryPrice(Product product, final double quantity, final double discount){
        double sum = 0;

        //discount
        sum += ((product.getPrice())-(product.getPrice()*discount/100))*quantity;
        return sum;
    }

    private void emptyCart(final Long id){

        ShoppingCart shoppingCart = shoppingCartRepository.findOne(id);

        List<PurchaseHistory> list = purchaseHistoryService.getAllPurchaseHistory();

        for (PurchaseHistory purchaseHistory:list){
            if (Objects.equals(purchaseHistory.getShoppingCart().getId(), id)){
                if(shoppingCart.getStatus()==Status.FORMING){

                    //return quantity to product if status FORMING
                    purchaseHistory.getProduct().setQuantity(purchaseHistory.getQuantity()+purchaseHistory.getProduct().getQuantity());
                }
                purchaseHistoryService.deletePurchaseHistory(purchaseHistory.getId());
            }
        }

        if (shoppingCart!=null){
            shoppingCart.getProducts().clear();
        }
    }
}