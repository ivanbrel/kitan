package by.ibrel.kitan.auth.service;

import by.ibrel.kitan.auth.dao.entity.Privilege;
import by.ibrel.kitan.auth.dao.repository.PrivilegeRepository;
import by.ibrel.kitan.auth.service.impl.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ibrel
 * @version 1.0 (12.08.2016)
 */

@Service
@Transactional
public class PrivilegeService implements IPrivilegeService {

    @Autowired
    private PrivilegeRepository repository;

    //API

    @Override
    public void save(Privilege entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(Privilege entity) {
        //TODO
    }

    @Override
    public List<Privilege> findAll() {
        return repository.findAll();
    }

    @Override
    public Privilege findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Privilege findByName(String name) {
        return repository.findByName(name);
    }
}
