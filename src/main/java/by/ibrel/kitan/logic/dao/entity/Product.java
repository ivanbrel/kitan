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
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by ibrel on 13/05/16.
 *
 */

@EqualsAndHashCode
@ToString
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
    private BigDecimal price;

    @Getter @Setter
    private String barcode;

    @Getter @Setter
    private String category;

    @Getter @Setter
    private Integer quantity;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IMAGE_ID")
    private Image image;

    public Product() {
    }

    public Product(String nameProduct, String model, String color, String countryProduct, BigDecimal price, String barcode, String category, Integer quantity, Image image){
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
