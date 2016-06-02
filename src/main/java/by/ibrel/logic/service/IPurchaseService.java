package by.ibrel.logic.service;

import by.ibrel.logic.entity.Client;
import by.ibrel.logic.entity.Product;
import by.ibrel.logic.entity.Purchase;

import java.util.Collection;

public interface IPurchaseService {

    Purchase createPurchase(PurchaseDto purchaseDto);

    Collection<Purchase> allPurchase();

    Client addClient(Long id);

    Product addProduct(Long id);

    void sellProduct();

    void delete(Long id);
}
