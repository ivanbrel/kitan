package by.ibrel.logic.service;

import by.ibrel.logic.entity.Category;
import by.ibrel.logic.exception.CategoryExistsException;
import by.ibrel.logic.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    /**
     *dependence problem categoryRepository !
     */

    @Autowired
    private CategoryRepository categoryRepository;

    //API

    @Override
    public Category createCategory(CategoryDto categoryDto) throws CategoryExistsException {
        if(categoryExists(categoryDto.getNameCategory())){
            throw new CategoryExistsException("Category with name " + categoryDto.getNameCategory() + "already exists");
        }

        final Category category = new Category();
        category.setNameCategory(categoryDto.getNameCategory());
        return categoryRepository.save(category);
    }

    private boolean categoryExists(String nameCategory) {
        final Category category = findByNameCategory(nameCategory);
        return category != null;
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category findByNameCategory(String nameCategory) {
        return categoryRepository.findByNameCategory(nameCategory);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Category category) {
        Category entity = findByNameCategory(category.getNameCategory());
        if(entity!=null){
            entity.setNameCategory(category.getNameCategory());
        }
        categoryRepository.save(entity);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }
}
