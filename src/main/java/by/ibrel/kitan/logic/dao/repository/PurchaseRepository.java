package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT p FROM Purchase p WHERE p.numberPurchase = (SELECT MAX(p.numberPurchase) FROM Purchase)")
    Purchase findMaxValue();
}
