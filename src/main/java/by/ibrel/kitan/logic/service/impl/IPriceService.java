package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.auth.service.impl.ICommonService;
import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.service.dto.PriceDto;

/**
 * @author ibrel
 * @version 1.1 (28.06.2016)
 */
public interface IPriceService extends ICommonService<Price>{

    Price addPrice(PriceDto priceDto);

}
