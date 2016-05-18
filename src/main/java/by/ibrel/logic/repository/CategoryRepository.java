package by.ibrel.logic.repository;

import by.ibrel.logic.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ibrel on 13/05/16.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.nameCategory = ?1")
    Category findByNameCategory(String nameCategory);
}
