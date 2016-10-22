package by.ibrel.kitan.logic.service.auth;

import by.ibrel.kitan.logic.dao.auth.entity.Privilege;
import by.ibrel.kitan.logic.dao.auth.repository.PrivilegeRepository;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.auth.impl.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ibrel
 * @version 1.0 (12.08.2016)
 */

@Service
public class PrivilegeService extends AbstractService<Privilege> implements IPrivilegeService {


    private PrivilegeRepository repository;

    @Autowired
    public PrivilegeService(final PrivilegeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    //API

    public Privilege findByName(String name) {
        return repository.findByName(name);
    }
}
