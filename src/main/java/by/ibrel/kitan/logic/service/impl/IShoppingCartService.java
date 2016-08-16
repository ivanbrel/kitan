package by.ibrel.kitan.logic.service.impl;


import by.ibrel.kitan.auth.service.impl.ICommonService;
import by.ibrel.kitan.logic.dao.entity.ShoppingCart;

/**
 * @author ibrel
 * @version 1.1 (13.05.2016)
 */
public interface IShoppingCartService extends ICommonService<ShoppingCart>{

    ShoppingCart createCart(Long clientId);

    ShoppingCart findCartWithClient(Long id);

    /**
     * Add in shopping cart product, and decrement entering quantity from product quantity
     *
     * @param shoppingCart object cart
     * @param quantity entering quantity
     * @throws Exception check on valid entering quantity (>0)
     */
    void sellProduct(ShoppingCart shoppingCart, Integer quantity) throws Exception;

    /**
     * Change status shopping cart
     *
     * @param id shopping cart id
     */
    void changeStatus(Long id);

    /**
     * Delete product from cart and if status "forming" return quantity to product
     *
     * @param cartId shopping cart id
     * @param histId history shopping id
     * @param productId product id
     */
    void deleteProductFromCart(Long cartId, Long histId, Long productId);

    /**
     *
     * @return if row>1 return quantity row + increment this number, else return 1
     */
    Integer findMaxValue();

}
