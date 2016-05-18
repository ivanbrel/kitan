package by.ibrel.logic.repository;

import by.ibrel.logic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ibrel on 13/05/16.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.nameProduct = ?1")
    Product findByName(String name);
}
