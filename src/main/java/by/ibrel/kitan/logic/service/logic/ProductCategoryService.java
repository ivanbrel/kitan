package by.ibrel.kitan.logic.service.logic;

import by.ibrel.kitan.logic.dao.logic.entity.ProductCategory;
import by.ibrel.kitan.logic.dao.logic.repository.ProductCatalogRepository;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.dao.logic.entity.dto.ProductCategoryDto;
import by.ibrel.kitan.logic.service.logic.impl.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author ibrel
 * @version 1.0 (22/09/16)
 */

@Service
public class ProductCategoryService extends AbstractService<ProductCategory> implements IProductCategoryService {

    private ProductCatalogRepository repository;

    @Autowired
    public ProductCategoryService(final ProductCatalogRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional
    public ProductCategory create(Object o) {

        final ProductCategoryDto productCategoryDto = (ProductCategoryDto) o;

        ProductCategory productCategory = new ProductCategory(productCategoryDto.getNameCategory(),productCategoryDto.getDescriptionCategory());
        save(productCategory);

        return productCategory;
    }

    @Override
    public ProductCategory findByName(String name) {
        return repository.findByName(name);
    }
}
