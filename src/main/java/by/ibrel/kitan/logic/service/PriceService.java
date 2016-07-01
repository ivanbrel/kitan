package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.repository.PriceRepository;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.service.dto.PriceDto;
import by.ibrel.kitan.logic.service.impl.IPriceService;
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
        repository.delete(id);
    }

    @Override
    public List<Price> allPrice() {
        return repository.findAll();
    }

    @Override
    public void updatePrice(Price price) {

        //TODO

    }

    @Override
    public void addToProduct(final Price price) {

        final Price entity = repository.findOne(price.getId());

        Product product = productRepository.findOne(price.getProduct().getId());
        entity.setProduct(product);

        repository.save(entity);
    }
}
