package by.ibrel.logic.service;

import by.ibrel.logic.entity.Client;
import by.ibrel.logic.entity.Product;
import by.ibrel.logic.entity.Purchase;

import java.util.Collection;
import java.util.List;

public interface IPurchaseService {

    Purchase createPurchase(Client client);

    List<Purchase> allPurchase();

    Client addClient(Long id);

    Product addProduct(Long id);

    void sellProduct(Purchase purchase);

    void delete(Long id);
}
