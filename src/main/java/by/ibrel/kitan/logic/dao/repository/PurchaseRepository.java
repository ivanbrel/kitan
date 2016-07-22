package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT MAX(numberPurchase) FROM Purchase")
    Integer findMaxValue();
}
