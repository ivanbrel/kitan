package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Query("SELECT MAX(numberCart) FROM ShoppingCart")
    Integer findMaxValue();
}
