package by.ibrel.kitan.logic.dao.entity;

import by.ibrel.kitan.logic.beans.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@EqualsAndHashCode
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
//    @Temporal(TemporalType.DATE)
    private String date;

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

//    @Getter @Setter
//    @OneToMany(mappedBy = "orderDetails", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//    private Collection<PurchaseHistory> purchaseHistories;

    @Getter @Setter
    @Enumerated
    private Status status;

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                '}';
    }
}

