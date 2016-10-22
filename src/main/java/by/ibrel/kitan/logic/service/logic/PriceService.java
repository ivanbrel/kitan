package by.ibrel.kitan.logic.service.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Price;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.logic.dto.PriceDto;
import by.ibrel.kitan.logic.service.logic.impl.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ibrel
 * @version 1.2 (28.06.2016)
 */
@Service
public class PriceService extends AbstractService<Price> implements IPriceService{

    @Autowired
    public PriceService(final JpaRepository<Price, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Price create(Object o) {

        PriceDto priceDto = (PriceDto) o;
        Price price = null;
        if (findAll().size()==0) {
            price = new Price(priceDto);
            save(price);
        }
        return price;
    }
}
