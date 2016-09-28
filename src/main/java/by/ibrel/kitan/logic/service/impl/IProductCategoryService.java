package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.auth.service.impl.ICommonService;
import by.ibrel.kitan.logic.dao.entity.ProductCategory;
import by.ibrel.kitan.logic.service.dto.ProductCategoryDto;

/**
 * @author ibrel
 * @version 1.0 (22/09/16)
 */
public interface IProductCategoryService extends ICommonService<ProductCategory> {

    ProductCategory addProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategory findByName(String name);
}
