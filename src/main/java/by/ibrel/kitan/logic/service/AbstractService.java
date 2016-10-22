package by.ibrel.kitan.logic.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


/**
 * @author ibrel
 * @version 1.0 (05/10/16)
 */
@Service
public abstract class AbstractService<T extends Serializable> implements ICommonService<T> {


    private JpaRepository<T,Long> repository;

    public AbstractService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(T entity){
        repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Long id){
        repository.delete(id);
    }

    @Override
    @Transactional
    public void update(T entity){
        save(entity);
    }

    @Override
    public List<T> findAll(){
        return repository.findAll();
    }

    @Override
    public T findOne(Long id){
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public T create(Object o){
        return (T) o;
    }
}
