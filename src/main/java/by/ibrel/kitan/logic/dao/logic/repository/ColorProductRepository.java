package by.ibrel.kitan.logic.dao.logic.repository;

import by.ibrel.kitan.logic.dao.logic.entity.ColorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
@Repository
public interface ColorProductRepository extends JpaRepository<ColorProduct, Long> {

    @Query("SELECT c FROM ColorProduct c WHERE c.name = ?1")
    ColorProduct findByName(String name);
}
