package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.ProductImage;
import by.ibrel.kitan.logic.dao.repository.ProductImageRepository;
import by.ibrel.kitan.logic.service.impl.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ibrel on 12/07/16.
 *
 */
@Service
@Transactional
public class ProductImageService implements IProductImageService {

    @Autowired
    private ProductImageRepository repository;


    @Override
    public ProductImage getProductImage(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void deleteProductImage(Long id) {
        repository.delete(id);
    }

    @Override
    public void updateProductImage(Long id) {
        //TODO
    }

    @Override
    public void saveProductImage(ProductImage productImage) {
        repository.save(productImage);
    }

}
