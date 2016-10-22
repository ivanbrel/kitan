package by.ibrel.kitan.logic.dao.logic.entity;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.beans.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Contract;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static by.ibrel.kitan.Const.*;

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

    @Getter
    private BigDecimal priceSummary;

    @Getter
    private Integer quantity;

    @Getter @Setter
    @Enumerated
    private Status status;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer numberCart, Client client, User user) {
        this.numberCart = numberCart(numberCart);
        this.client = client;
        this.priceSummary = BigDecimal.ZERO;
        this.quantity = INIT_INT;
        this.user = user;
        date = new Date();
        products = new ArrayList<>();
        status = Status.CREATE;
    }

    /**
     * get max value in table "purchase", for find max value == number purchase
     *
     * @return value
     */
    @Contract(pure = true)
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
     * @param price price product
     * @param quantity entering quantity products
     * @param discount Client personal discount
     * @return summary price
     */
    public BigDecimal summaryPrice(BigDecimal price, BigDecimal discount, Integer quantity){
        //BigDecimal sum = BigDecimal.ZERO;
        //discount
        //sum += ((product.getPrice())-(product.getPrice()*discount/100))*quantity;
        return (price.subtract(discount.multiply(price).divide(BigDecimal.valueOf(100),3))).multiply(BigDecimal.valueOf(quantity));
    }

    public void changeStatusFormed(ShoppingCart shoppingCart) {
        shoppingCart.setStatus(Status.FORMED);
    }

    public void changeStatusForming(ShoppingCart shoppingCart) {
        shoppingCart.setStatus(Status.FORMING);
    }

    public void incSum(BigDecimal incSum){
        this.priceSummary = getPriceSummary().add(incSum);
    }

    public void decSum(BigDecimal decSum){
        if (getPriceSummary().compareTo(decSum)>=0)
        this.priceSummary = getPriceSummary().subtract(decSum);
    }

    public void incQuantity(Integer incQuantity){
        this.quantity = getQuantity()+incQuantity;
    }

    public void decQuantity(Integer decQuantity){
        if (getQuantity()>=decQuantity)
            this.quantity = getQuantity()-decQuantity;
    }

}

