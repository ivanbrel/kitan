package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.auth.service.impl.ICommonService;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.entity.PurchaseHistory;
import by.ibrel.kitan.logic.dao.entity.ShoppingCart;

import java.util.List;

/**
 * @author ibrel
 * @version 1.1 (28.07.2016)
 */
public interface IPurchaseHistoryService extends ICommonService<PurchaseHistory>{

    /**
     * @param cartId id shopping cart
     * @return purchase history for specific cart
     */
    List<PurchaseHistory> listHistory(Long cartId);

    void createPurchaseHistory(ShoppingCart shoppingCart, final Product product, final Integer count);
}
