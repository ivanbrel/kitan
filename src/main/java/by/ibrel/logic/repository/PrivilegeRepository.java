package by.ibrel.logic.repository;

import by.ibrel.logic.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ibrel on 08.04.2016.
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);
}
