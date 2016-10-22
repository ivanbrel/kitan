package by.ibrel.kitan.logic.service.logic.impl;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.dao.logic.entity.ShoppingCart;
import by.ibrel.kitan.logic.exception.logic.PurchaseQuantityLimitException;
import by.ibrel.kitan.logic.service.ICommonService;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IShoppingCartService extends ICommonService<ShoppingCart> {

    ShoppingCart create(final Long clientId, final User user);

    void sellProduct(final ShoppingCart shoppingCart, final Integer quantity, String seller) throws PurchaseQuantityLimitException;

    void deleteProductFromCart(Long cartId, Long histId, Long productId);
}
