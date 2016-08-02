package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.service.dto.ProductDto;

import java.io.IOException;
import java.util.List;


/**
 * Created by ibrel on 13/05/16.
 *
 */
public interface IProductService {

    Product addProduct(ProductDto productDto);

    void editProduct(Product product);

    void saveProduct(Product product);

    void deleteProduct(Long id) throws IOException;

    List<Product> listAllProduct();

    Product getProduct(Long id);
}
