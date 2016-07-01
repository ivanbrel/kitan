package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.entity.Purchase;

import java.util.List;

public interface IPurchaseService {

    Purchase createPurchase(Client client);

    List<Purchase> allPurchase();

    void sellProduct(Purchase purchase, Integer count);

    void delete(Long id);
}
