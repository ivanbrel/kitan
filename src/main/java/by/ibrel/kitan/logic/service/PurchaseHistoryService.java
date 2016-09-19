package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.entity.PurchaseHistory;
import by.ibrel.kitan.logic.dao.entity.ShoppingCart;
import by.ibrel.kitan.logic.dao.repository.PurchaseHistoryRepository;
import by.ibrel.kitan.logic.service.impl.IPurchaseHistoryService;
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
@Transactional
public class PurchaseHistoryService implements IPurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepository repository;

//    API

    @Override
    public List<PurchaseHistory> listHistory(Long cartId) {

        List<PurchaseHistory> returnList = new ArrayList<>();
        for (PurchaseHistory purchaseHistory:findAll()){
            if (Objects.equals(purchaseHistory.getShoppingCart().getId(), cartId)){
                returnList.add(purchaseHistory);
            }
        }
        return returnList;
    }

    @Override
    public void createPurchaseHistory(ShoppingCart shoppingCart, Product product, Integer quantity, BigDecimal priceWithDiscount, String seller) {
        if (product!=null) {
            save(new PurchaseHistory(shoppingCart.getClient(),shoppingCart,product,
                    quantity,product.getPrice().multiply(BigDecimal.valueOf(quantity)), priceWithDiscount,seller));
        }
    }

    @Override
    public void save(PurchaseHistory entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(PurchaseHistory entity) {
        //TODO
    }

    @Override
    public List<PurchaseHistory> findAll() {
        return repository.findAll();
    }

    @Override
    public PurchaseHistory findOne(Long id) {
        return repository.findOne(id);
    }
}
