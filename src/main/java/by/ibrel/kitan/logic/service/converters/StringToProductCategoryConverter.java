package by.ibrel.kitan.logic.service.converters;

import by.ibrel.kitan.logic.dao.entity.ProductCategory;
import by.ibrel.kitan.logic.service.impl.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * @author ibrel
 * @version 1.0 (27/09/16)
 */
public class StringToProductCategoryConverter implements Converter<String,ProductCategory> {

    private IProductCategoryService productCategoryService;

    @Autowired
    public StringToProductCategoryConverter(IProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @Override
    public ProductCategory convert(String nameProductCategoryString) {
        Converter<String,ProductCategory> categoryConverter = productCategoryService::findByName;
        return categoryConverter.convert(nameProductCategoryString);
    }

}
