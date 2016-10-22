package by.ibrel.kitan.logic.dao.logic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ibrel on 27/07/16.
 *
 */
@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    @Getter @Setter
    private Long id;

}
