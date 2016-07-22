package by.ibrel.kitan.auth.dao.repository;

import by.ibrel.kitan.auth.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by ibrel on 08.04.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.login = ?1")
    User findByUser(String name);
}
