package by.ibrel.kitan.logic.dao.logic.repository;

import by.ibrel.kitan.logic.dao.logic.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Query("SELECT MAX(numberCart) FROM ShoppingCart")
    Integer findMaxValue();

    @Query("select cart from ShoppingCart cart where cart.client.id = ?1")
    ShoppingCart findShoppingCartWithClient(Long id);
}
