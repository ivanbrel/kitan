package by.ibrel.kitan.logic.dao.logic.repository;

import by.ibrel.kitan.logic.dao.logic.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ibrel on 12/07/16.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image,Long>{
}
