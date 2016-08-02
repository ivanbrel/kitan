package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by ibrel on 07/07/16.
 *
 */
@EqualsAndHashCode
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
    private String date;

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "id=" + id +
                '}';
    }
}
