package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.dao.repository.PriceRepository;
import by.ibrel.kitan.logic.service.impl.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author ibrel
 * @version 1.2 (28.06.2016)
 */
@Service
@Transactional
public class PriceService implements IPriceService {

    @Autowired
    private PriceRepository repository;

//    API

    @Override
    public void save(Price entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(Price price) {

        Price entity = repository.findOne(price.getId());

        if (entity!=null) {
            entity.setRubleBY(price.getRubleBY());
            entity.setRubleRUS(price.getRubleRUS());
            entity.setEuro(price.getEuro());
            entity.setGrivUA(price.getGrivUA());
            entity.setChinaUAN(price.getChinaUAN());
            entity.setPolandZLOT(price.getPolandZLOT());
        }
        repository.save(entity);
    }

    @Override
    public List<Price> findAll() {
        return repository.findAll();
    }

    @Override
    public Price findOne(Long id) {
        return repository.findOne(id);
    }


}
