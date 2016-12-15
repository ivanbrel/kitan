package by.ibrel.kitan.logic.dao.auth.repository;

import by.ibrel.kitan.logic.dao.auth.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by ibrel on 08.04.2016.
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);
}
