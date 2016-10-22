package by.ibrel.kitan.logic.service.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.dao.logic.entity.PurchaseHistory;
import by.ibrel.kitan.logic.dao.logic.entity.ShoppingCart;
import by.ibrel.kitan.logic.dao.logic.repository.PurchaseHistoryRepository;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.logic.impl.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ibrel
 * @version 1.2 (12.07.2016)
 */

@Service
public class PurchaseHistoryService extends AbstractService<PurchaseHistory> implements IPurchaseHistoryService{

    @Autowired
    public PurchaseHistoryService(final PurchaseHistoryRepository repository) {
        super(repository);
    }

//    API

    public List<PurchaseHistory> listHistory(Long cartId) {

        List<PurchaseHistory> returnList = new ArrayList<>();
        for (PurchaseHistory purchaseHistory:findAll()){
            if (Objects.equals(purchaseHistory.getShoppingCart().getId(), cartId)){
                returnList.add(purchaseHistory);
            }
        }
        return returnList;
    }

    @Transactional
    public void create(ShoppingCart shoppingCart, Product product, Integer quantity, BigDecimal priceWithDiscount, String seller) {
        if (product!=null) {
            save(new PurchaseHistory(shoppingCart.getClient(),shoppingCart,product,
                    quantity,product.getPrice().multiply(BigDecimal.valueOf(quantity)), priceWithDiscount,seller));
        }
    }

}
