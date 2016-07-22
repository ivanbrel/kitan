package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.InfoPurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by ibrel on 07/07/16.
 *
 */
public interface InfoPurchaseProductRepository extends JpaRepository<InfoPurchaseProduct, Long> {
}
