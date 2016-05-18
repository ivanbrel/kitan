package by.ibrel.logic.service;

import by.ibrel.logic.entity.Client;
import by.ibrel.logic.entity.Product;

import java.util.List;

/**
 * Created by ibrel on 13/05/16.
 */
public interface IProductService {

    Product addProduct(ProductDto productDto);

    void editProduct(Product product);

    void saveProduct(Product product);

    void deleteProduct(Long id);

    void sellProduct(Long id);

    List<Product> listAllProduct();

    boolean checkStatus(Long id);

    Product getProduct(Long id);

    Product addClient(Client client);
}
