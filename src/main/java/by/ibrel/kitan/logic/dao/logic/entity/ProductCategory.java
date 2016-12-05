package by.ibrel.kitan.logic.dao.logic.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ibrel
 * @version 1.0 (22/09/16)
 */

@Entity
@Table(name = "product_category", schema = "LOGIC")
public class ProductCategory extends AbstractCatalog implements Serializable{

    private static final long serialVersionUID = 1L;

    public ProductCategory() {
    }

    public ProductCategory(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return getName();
    }
}
