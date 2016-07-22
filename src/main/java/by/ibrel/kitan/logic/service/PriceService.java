package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.PriceConvert;
import by.ibrel.kitan.logic.dao.repository.PriceRepository;
import by.ibrel.kitan.logic.service.impl.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by ibrel on 28/06/16.
 *
 */
@Service
@Transactional
public class PriceService implements IPriceService {

    @Autowired
    private PriceRepository repository;

//    API

    @Override
    public PriceConvert getPriceById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<PriceConvert> findAll() {
        return repository.findAll();
    }

    @Override
    public void updatePrice(PriceConvert price) {

        PriceConvert entity = repository.findOne(price.getId());

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

}
