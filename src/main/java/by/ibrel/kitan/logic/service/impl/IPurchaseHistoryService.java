package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.entity.PurchaseHistory;
import by.ibrel.kitan.logic.dao.entity.ShoppingCart;

import java.util.List;

/**
 * Created by ibrel on 28/07/16.'
 *
 */
public interface IPurchaseHistoryService {

    void savePurchaseHistory(PurchaseHistory purchaseHistory);

    void deletePurchaseHistory(Long id);

    PurchaseHistory getPurchaseHistory(Long id);

    List<PurchaseHistory> getAllPurchaseHistory();

    /**
     * @param cartId id shopping cart
     * @return purchase history for specific cart
     */
    List<PurchaseHistory> listHistory(Long cartId);

    void createPurchaseHistory(ShoppingCart shoppingCart, final Product product, final Integer count);
}
