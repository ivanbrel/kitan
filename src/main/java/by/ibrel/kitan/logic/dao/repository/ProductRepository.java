package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * Created by ibrel on 13/05/16.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.nameProduct = ?1")
    Product findByName(String name);
}
