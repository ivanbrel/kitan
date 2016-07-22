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
@Table(name = "detail_info_purchase")
public class InfoPurchaseProduct implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "PURCHASE_ID")
    private Purchase purchase;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Getter @Setter
    private Integer count;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    private Double discount;

    @Getter @Setter
    private Integer numberPurchase;

    @Override
    public String toString() {
        return "InfoPurchaseProduct{" +
                "id=" + id +
                '}';
    }
}
