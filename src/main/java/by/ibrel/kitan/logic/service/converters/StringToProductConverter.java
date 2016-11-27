package by.ibrel.kitan.logic.service.converters;

import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.service.logic.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * @author ibrel
 * @version 1.0 (28/09/16)
 */
public class StringToProductConverter implements Converter<String,Product> {

    @Autowired
    private IProductService productService;

    @Override
    public Product convert(String s) {
        Converter<String,Long> converter = Long::parseLong;
        return productService.findOne(converter.convert(s));
    }
}
