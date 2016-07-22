package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by ibrel on 13/05/16.
 *
 */

@EqualsAndHashCode
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nameProduct;

    @Getter @Setter
    private String model;

    @Getter @Setter
    private String color;

    @Getter @Setter
    private String countryProduct;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    private String barcode;

    @Getter @Setter
    private String category;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
//    @NotFound(action = NotFoundAction.IGNORE)
    private Collection<Purchase> purchases;

    //check the status of the product, if true means free
    @Getter @Setter
    private boolean state;

    //check the status of the product, if true means product sales
    @Getter @Setter
    private boolean sales;

    @Getter @Setter
    private Integer count;

    @Getter @Setter
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "product_newcolumn")
    private List<String> newColumn;

    @Getter @Setter
    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)
    private InfoPurchaseProduct infoPurchaseProduct;

    @Getter @Setter
    @OneToOne(mappedBy = "product",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private ProductImage productImage;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                '}';
    }
}
