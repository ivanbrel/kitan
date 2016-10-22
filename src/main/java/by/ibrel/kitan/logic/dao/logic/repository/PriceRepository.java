package by.ibrel.kitan.logic.dao.logic.repository;

import by.ibrel.kitan.logic.dao.logic.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ibrel on 28/06/16.
 *
 */
public interface PriceRepository extends JpaRepository<Price, Long> {
}
