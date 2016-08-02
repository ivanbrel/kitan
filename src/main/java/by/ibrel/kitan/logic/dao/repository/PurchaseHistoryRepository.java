package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

/**
 * Created by ibrel on 07/07/16.
 *
 */
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query("select p from PurchaseHistory p where p.shoppingCart = ?1")
    List<PurchaseHistory> listPurchasesContainsCar(Long idCart);
}
