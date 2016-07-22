package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.logic.dao.entity.ProductImage;



/**
 * Created by ibrel on 12/07/16.
 *
 */
public interface IProductImageService {

    ProductImage getProductImage(Long id);

    void deleteProductImage(Long id);

    void updateProductImage(Long id);

    void saveProductImage(ProductImage productImage);

}
