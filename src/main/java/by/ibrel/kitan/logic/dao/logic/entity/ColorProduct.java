package by.ibrel.kitan.logic.dao.logic.entity;

import by.ibrel.kitan.logic.dao.logic.entity.dto.ColorProductDto;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
@Entity
@Table(name = "color_product", schema = "LOGIC")
public class ColorProduct extends AbstractCatalog implements Serializable{

    private static final long serialVersionUID = 1L;

    public ColorProduct() {
    }

    public ColorProduct(String name, String description) {
        super(name, description);
    }

    public ColorProduct(ColorProductDto productDto){
        this(productDto.getNameColorProduct(),productDto.getDescriptionColorProduct());
    }

    @Override
    public String toString() {
        return getName();
    }
}
