package by.ibrel.kitan.logic.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;;

/**
 * Created by ibrel on 12/07/16.
 *
 */

@Entity
@Table(name = "product_image")
public class ProductImage extends AbstractFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage() {
        super();
    }
}
