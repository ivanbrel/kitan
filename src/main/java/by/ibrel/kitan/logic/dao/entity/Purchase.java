package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@EqualsAndHashCode
@Entity
@Table(name = "purchase")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PURCHASE_ID")
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Integer numberPurchase;

    @Getter @Setter
//    @Temporal(TemporalType.DATE)
    private String date;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "purchase_product", joinColumns = @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "PURCHASE_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID"))
    private Collection<Product> products;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @Getter @Setter
    private Double priceSummary;

    @Getter @Setter
    private Integer countSummary;

    @Getter @Setter
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.REMOVE)
    private Collection<InfoPurchaseProduct> infoPurchaseProducts;

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                '}';
    }
}

