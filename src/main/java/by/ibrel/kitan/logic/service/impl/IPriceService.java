package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.service.dto.PriceDto;

import java.util.List;

/**
 * Created by ibrel on 28/06/16.
 */
public interface IPriceService {

    Price addPrice(PriceDto priceDto);

    void savePrice(Price price);

    void deletePrice(Long id);

    Price findById(Long id);

    List<Price> allPrice();

    void updatePrice(Price price);

    void addToProduct(Price price);
}
