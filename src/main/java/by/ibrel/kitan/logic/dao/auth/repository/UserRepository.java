package by.ibrel.kitan.logic.dao.auth.repository;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Created by ibrel on 08.04.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.login = ?1")
    User findByUser(String name);
}
