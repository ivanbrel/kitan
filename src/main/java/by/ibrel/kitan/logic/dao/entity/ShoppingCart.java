package by.ibrel.kitan.logic.dao.entity;

import by.ibrel.kitan.logic.beans.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static by.ibrel.kitan.logic.Const.*;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Integer numberCart;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "catr_product", joinColumns = @JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID"))
    private Collection<Product> products;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @Getter @Setter
    private Double priceSummary;

    @Getter @Setter
    private Integer quantity;

    @Getter @Setter
    @Enumerated
    private Status status;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer numberCart, Client client) {
        this.numberCart = numberCart(numberCart);
        this.client = client;
        this.priceSummary = INIT_DOUBLE;
        this.quantity = INIT_INT;
        date = new Date();
        products = new ArrayList<>();
        status = Status.CREATE;
    }

    /**
     * get max value in table "purchase", for find max value == number purchase
     *
     * @return value
     */
    private Integer numberCart(Integer value){
        if(value!= null) {
            Integer i = value;
            return ++i;
        }else {
            return START_NUMBER;
        }
    }

    public void addToProducts(Product product){
        products.add(product);
    }

    /**
     * Calculating summary price with discount
     *
     * @param product object product
     * @param quantity entering quantity products
     * @param discount Client personal discount
     * @return summary price
     */
    public double summaryPrice(Product product, final double quantity, final double discount){
        double sum = INIT_DOUBLE;

        //discount
        sum += ((product.getPrice())-(product.getPrice()*discount/100))*quantity;
        return sum;
    }

    public void changeStatusFormed(ShoppingCart shoppingCart) {
        shoppingCart.setStatus(Status.FORMED);
    }

    public void changeStatusForming(ShoppingCart shoppingCart) {
        shoppingCart.setStatus(Status.FORMING);
    }
}

