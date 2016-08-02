package by.ibrel.kitan.logic.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;;

/**
 * Created by ibrel on 12/07/16.
 *
 */

@Entity
@Table(name = "image")
@DynamicUpdate
@DynamicInsert
public class Image extends AbstractFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Image() {
        super();
    }
}
