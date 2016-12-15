package by.ibrel.kitan.logic.dao.logic.repository;

import by.ibrel.kitan.logic.dao.logic.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ibrel
 * @version 1.0 (22/09/16)
 */
public interface ProductCatalogRepository extends JpaRepository<ProductCategory,Long> {

    ProductCategory findByName(String name);
}
