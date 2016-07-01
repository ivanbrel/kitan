package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ibrel on 13/05/16.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.lastName = ?1")
    Client findByLastName(String lastName);

    @Query("select c from Client c where c.account = ?1")
    Client findByAccount(String account);
}
