package by.ibrel.kitan.logic.service.logic.impl;

import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.dao.logic.entity.PurchaseHistory;
import by.ibrel.kitan.logic.dao.logic.entity.ShoppingCart;
import by.ibrel.kitan.logic.service.ICommonService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IPurchaseHistoryService extends ICommonService<PurchaseHistory> {

    List<PurchaseHistory> listHistory(Long cartId);

    void create(ShoppingCart shoppingCart, Product product, Integer quantity, BigDecimal priceWithDiscount, String seller);
}
