package by.ibrel.kitan.logic.service.logic.impl;

import by.ibrel.kitan.logic.dao.logic.entity.ColorProduct;
import by.ibrel.kitan.logic.service.ICommonService;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
public interface IColorProductService extends ICommonService<ColorProduct> {

    ColorProduct findByName(String name);
}
