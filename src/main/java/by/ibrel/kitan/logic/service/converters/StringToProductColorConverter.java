package by.ibrel.kitan.logic.service.converters;

import by.ibrel.kitan.logic.dao.logic.entity.ColorProduct;
import by.ibrel.kitan.logic.service.logic.impl.IColorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (13.12.2016)
 * @datechange (13.12.2016)
 */
@Component
public class StringToProductColorConverter implements Converter<String,ColorProduct> {

    @Autowired
    private IColorProductService productService;

    @Override
    public ColorProduct convert(String name) {
        Converter<String,ColorProduct> categoryConverter = productService::findByName;
        return categoryConverter.convert(name);
    }
}
