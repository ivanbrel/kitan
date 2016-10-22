package by.ibrel.kitan.logic.service;


import java.util.List;

/**
 * @author ibrel
 * @version 1.0 (12.08.2016)
 */
public interface ICommonService<T> {

    void save(T entity);

    void delete(Long id);

    void update(T entity);

    List<T> findAll();

    T findOne(Long id);

    T create(Object o);
}
