package by.ibrel.logic.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ibrel on 13/05/16.
 */
@Entity
public class Category {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Long id;

    private String nameCategory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Collection<Product> products;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (!id.equals(category.id)) return false;
        return nameCategory.equals(category.nameCategory);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nameCategory.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                ", products=" + products +
                '}';
    }
}
