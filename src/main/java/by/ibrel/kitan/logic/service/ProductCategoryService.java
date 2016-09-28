package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.ProductCategory;
import by.ibrel.kitan.logic.dao.repository.ProductCatalogRepository;
import by.ibrel.kitan.logic.service.dto.ProductCategoryDto;
import by.ibrel.kitan.logic.service.impl.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ibrel
 * @version 1.0 (22/09/16)
 */

@Service
@Transactional
public class ProductCategoryService implements IProductCategoryService {

    private ProductCatalogRepository repository;

    @Autowired
    public ProductCategoryService(final ProductCatalogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(ProductCategory entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(ProductCategory entity) {
        ProductCategory productCategory = findOne(entity.getId());
        if (productCategory!=null){
            productCategory.setName(entity.getName());
            productCategory.setDescription(entity.getDescription());
        }
        save(productCategory);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductCategory findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public ProductCategory addProductCategory(ProductCategoryDto productCategoryDto) {

        ProductCategory productCategory = new ProductCategory(productCategoryDto.getNameCategory(),productCategoryDto.getDescriptionCategory());
        save(productCategory);

        return productCategory;
    }

    @Override
    public ProductCategory findByName(String name) {
        return repository.findByName(name);
    }
}
