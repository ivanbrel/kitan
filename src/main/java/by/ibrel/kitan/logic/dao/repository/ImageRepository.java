package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by ibrel on 12/07/16.
 */
public interface ImageRepository extends JpaRepository<Image,Long>{
}
