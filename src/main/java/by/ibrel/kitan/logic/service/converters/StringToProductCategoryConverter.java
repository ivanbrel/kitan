package by.ibrel.kitan.logic.service.converters;

import by.ibrel.kitan.logic.dao.logic.entity.ProductCategory;
import by.ibrel.kitan.logic.service.logic.impl.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * @author ibrel
 * @version 1.0 (27/09/16)
 */
public class StringToProductCategoryConverter implements Converter<String,ProductCategory> {

    @Autowired
    private IProductCategoryService productCategoryService;

    @Override
    public ProductCategory convert(String nameProductCategoryString) {
        Converter<String,ProductCategory> categoryConverter = productCategoryService::findByName;
        return categoryConverter.convert(nameProductCategoryString);
    }

}
