package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.entity.PurchaseHistory;
import by.ibrel.kitan.logic.dao.entity.ShoppingCart;
import by.ibrel.kitan.logic.dao.repository.PurchaseHistoryRepository;
import by.ibrel.kitan.logic.service.impl.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        List<PurchaseHistory> list = findAll();
        List<PurchaseHistory> returnList = new ArrayList<>();
        for (PurchaseHistory purchaseHistory:list){
            if (Objects.equals(purchaseHistory.getShoppingCart().getId(), cartId)){
                returnList.add(purchaseHistory);
            }
        }
        return returnList;
    }

    @Override
    public void createPurchaseHistory(ShoppingCart shoppingCart, Product product, Integer count) {
        if (product!=null) {

            PurchaseHistory purchaseHistory = new PurchaseHistory();
            purchaseHistory.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
            purchaseHistory.setProduct(product);
            purchaseHistory.setQuantity(count);
            purchaseHistory.setPrice(product.getPrice()*count);
            purchaseHistory.setShoppingCart(shoppingCart);
            purchaseHistory.setClient(shoppingCart.getClient());

            save(purchaseHistory);
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
