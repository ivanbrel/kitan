package by.ibrel.kitan.logic.dao.logic.repository;

import by.ibrel.kitan.logic.dao.logic.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by ibrel on 13/05/16.
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.name = ?1")
    Client findByName(String lastName);
}
