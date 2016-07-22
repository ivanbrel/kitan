package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by ibrel on 12/07/16.
 */
public interface ProductImageRepository extends JpaRepository<ProductImage,Long>{
}
