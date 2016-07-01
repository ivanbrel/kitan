package by.ibrel.kitan.auth.dao.repository;

import by.ibrel.kitan.auth.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ibrel on 08.04.2016.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
