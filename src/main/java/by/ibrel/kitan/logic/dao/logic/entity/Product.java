package by.ibrel.kitan.logic.dao.logic.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ibrel on 13/05/16.
 *
 */

@EqualsAndHashCode
@ToString
@Getter@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String nameProduct;

    private String model;

    private String color;

    private String countryProduct;

    private BigDecimal price;

    private String barcode;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    private ProductCategory category;

    private Integer quantity;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IMAGE_ID")
    private Image image;

    public Product() {
    }

    public Product(String nameProduct, String model, String color, String countryProduct, BigDecimal price, String barcode, ProductCategory category, Integer quantity, Image image){
        this.nameProduct = nameProduct;
        this.model = model;
        this.color = color;
        this.countryProduct = countryProduct;
        this.price = price;
        this.barcode = barcode;
        this.category = category;
        this.quantity = quantity;
        this.image = image;
    }

    public void incQuantity(Integer incQuantity){
        this.quantity = getQuantity()+incQuantity;
    }

    public void decQuantity(Integer decQuantity){
        if (getQuantity()>=decQuantity)
            this.quantity = getQuantity() - decQuantity;
    }
}
