package by.ibrel.kitan.logic.dao.logic.repository;

import by.ibrel.kitan.logic.dao.logic.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ibrel on 28/06/16.
 *
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
