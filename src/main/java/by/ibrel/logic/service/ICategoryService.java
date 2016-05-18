package by.ibrel.logic.service;

import by.ibrel.logic.entity.Category;
import by.ibrel.logic.exception.CategoryExistsException;

import java.util.List;

/**
 * Created by ibrel on 13/05/16.
 */
public interface ICategoryService {

    Category createCategory(CategoryDto categoryDto) throws CategoryExistsException;

    Category getCategory(Long id);

    Category findByNameCategory(String nameCategory);

    List<Category> findAllCategory();

    void updateCategory(Category category);

    void deleteCategory(Long id);
}
