package by.ibrel.kitan.logic.service.impl;



import by.ibrel.kitan.logic.dao.entity.PriceConvert;

import java.util.List;


/**
 * Created by ibrel on 28/06/16.
 *
 */
public interface IPriceService {

    PriceConvert getPriceById(Long id);

    List<PriceConvert> findAll();

    void updatePrice(PriceConvert price);
}
