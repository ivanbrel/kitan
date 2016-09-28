package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.logic.beans.Status;
import by.ibrel.kitan.logic.dao.entity.*;
import by.ibrel.kitan.logic.dao.repository.ShoppingCartRepository;
import by.ibrel.kitan.logic.exception.ProductCanNotBeDeleted;
import by.ibrel.kitan.logic.exception.PurchaseQuantityLimitException;
import by.ibrel.kitan.logic.service.impl.IClientService;
import by.ibrel.kitan.logic.service.impl.IProductService;
import by.ibrel.kitan.logic.service.impl.IPurchaseHistoryService;
import by.ibrel.kitan.logic.service.impl.IShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

import static by.ibrel.kitan.logic.Const.START_NUMBER;

/**
 * @author ibrel
 * @version 1.3 (28.07.2016)
 */

@Service
@Transactional
public class ShoppingCartService implements IShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private IClientService clientService;
    private IProductService productService;
    private IPurchaseHistoryService purchaseHistoryService;

    //API


    public ShoppingCartService() {
    }

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, IClientService clientService, IProductService productService, IPurchaseHistoryService purchaseHistoryService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.clientService = clientService;
        this.productService = productService;
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @Override
    public ShoppingCart createCart(final Long clientId, final User user) {

        final Client client = clientService.findOne(clientId);
        ShoppingCart shoppingCart = new ShoppingCart(findMaxValue(), client, user);
        save(shoppingCart);
        return shoppingCart;
    }

    @Override
    public ShoppingCart findCartWithClient(Long id) {
        return shoppingCartRepository.findShoppingCartWithClient(id);
    }

    @Override
    public synchronized void sellProduct(final ShoppingCart shoppingCart, final Integer quantity, String seller) throws PurchaseQuantityLimitException {

        BigDecimal priceWithDiscount = BigDecimal.ZERO;
        ShoppingCart entity = shoppingCartRepository.findOne(shoppingCart.getId());
        Product productForHistory = new Product();

        for (Product product : shoppingCart.getProducts()) {
            product = productService.findOne(product.getId());
            if (quantity > 0 && quantity <= product.getQuantity()) {
                if (!entity.getProducts().contains(product)) {
                    entity.addToProducts(product);
                }

                priceWithDiscount = shoppingCart.summaryPrice(product.getPrice(), entity.getClient().getDiscountPrice(), quantity);
                entity.incSum(priceWithDiscount);
                entity.incQuantity(quantity);
                product.decQuantity(quantity);
                productService.save(product);
                productForHistory = product;

            } else {
                throw new PurchaseQuantityLimitException();
            }
        }

        if (!entity.getProducts().contains(productForHistory))
            entity.addToProducts(productForHistory);

        entity.changeStatusForming(entity);
        save(entity);
        purchaseHistoryService.createPurchaseHistory(entity, productForHistory, quantity, priceWithDiscount, seller);
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
        if (entity != null) {
            //TODO дописать
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
    public synchronized void deleteProductFromCart(Long cartId, Long histId, Long productId) {

        ShoppingCart shoppingCart = findOne(cartId);
        PurchaseHistory purchaseHistory = purchaseHistoryService.findOne(histId);
        Product product = productService.findOne(productId);

//        List<Product> products = (List<Product>) shoppingCart.getProducts();
//        ListIterator<Product> iterator = products.listIterator();

        //TODO check on exists another product
//        while (iterator.hasNext()) {
//            if (iterator.next().getId().equals(productId)) {
//                iterator.remove();
//            }
//        }

        //set quantity for cart
        shoppingCart.decQuantity(purchaseHistory.getQuantity());

        //set price for cart
        shoppingCart.decSum(purchaseHistory.getPriceWithDiscount());

        //set quantity for product
        product.incQuantity(purchaseHistory.getQuantity());

        //delete history
        purchaseHistoryService.delete(purchaseHistory.getId());
    }

    @Override
    public Integer findMaxValue() {
        return shoppingCartRepository.findMaxValue();
    }

    /**
     * Removed all reference on object Cart
     *
     * @param id shopping cart id
     */
    private void emptyCart(final Long id) {

        ShoppingCart shoppingCart = findOne(id);

        for (PurchaseHistory purchaseHistory : purchaseHistoryService.findAll()) {
            if (Objects.equals(purchaseHistory.getShoppingCart().getId(), id)) {
                if (shoppingCart.getStatus() == Status.FORMING) {

                    //return quantity to product if status FORMING
                    purchaseHistory.getProduct().incQuantity(purchaseHistory.getQuantity());
                }
                purchaseHistoryService.delete(purchaseHistory.getId());
            }
        }

        if (shoppingCart != null) {
            shoppingCart.getProducts().clear();
        }
    }
}