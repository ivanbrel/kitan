package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.repository.PriceRepository;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.service.dto.PriceDto;
import by.ibrel.kitan.logic.service.impl.IPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrel on 28/06/16.
 */
@Service
@Transactional
public class PriceService implements IPriceService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private PriceRepository repository;

    @Autowired
    private ProductRepository productRepository;

//    API

    @Override
    public Price addPrice(final PriceDto priceDto) {

        final Price price = new Price();

        price.setPriceForProduct(priceDto.getPriceForProduct());
        price.setByRuble(priceDto.getByRuble());
        price.setRusRuble(priceDto.getRusRuble());
        price.setUsaDollar(priceDto.getUsaDollar());

        return repository.save(price);
    }

    @Override
    public void savePrice(Price price) {
        repository.save(price);
    }

    @Override
    public void deletePrice(Long id) {
        final Price price = repository.findOne(id);

        if (price.getProduct() != null){
            //TODO display a message
            LOGGER.info("Warning, price associated with product");
        }
        repository.delete(id);
    }

    @Override
    public Price findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Price> allPrice() {
        return repository.findAll();
    }

    @Override
    public void updatePrice(Price price) {

        Price entity = repository.findOne(price.getId());

        if (entity!=null) {
            entity.setPriceForProduct(price.getPriceForProduct());
            entity.setByRuble(price.getByRuble());
            entity.setRusRuble(price.getRusRuble());
            entity.setUsaDollar(price.getUsaDollar());
        }
        repository.save(entity);
    }

    @Override
    public void addToProduct(final Price price) {

        final Price entity = repository.findOne(price.getId());

        Product product = productRepository.findOne(price.getProduct().getId());
        entity.setProduct(product);

        repository.save(entity);
    }
}
