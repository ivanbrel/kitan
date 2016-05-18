package by.ibrel.logic.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ibrel on 13/05/16.
 */
public class CategoryDto {

    @NotNull
    @Size(min = 1)
    private String nameCategory;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
