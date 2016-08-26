package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by ibrel on 07/07/16.
 *
 */
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private ShoppingCart shoppingCart;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "ORDERDETAILS_ID")
    private OrderDetails orderDetails;

    @Getter @Setter
    private Integer quantity;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    public PurchaseHistory() {
    }

    public PurchaseHistory(Client client, ShoppingCart shoppingCart, Product product, Integer quantity, Double price) {
        this.client = client;
        this.shoppingCart = shoppingCart;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        orderDetails = orderDetails;
        date = new Date();
    }


}
