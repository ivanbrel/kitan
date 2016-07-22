package by.ibrel.kitan.logic.dao.repository;

import by.ibrel.kitan.logic.dao.entity.PriceConvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by ibrel on 28/06/16.
 *
 */
public interface PriceRepository extends JpaRepository<PriceConvert, Long> {
}
