package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by ibrel on 13/05/16.
 *
 */
@Entity
@Table(name = "client")
@EqualsAndHashCode
@ToString
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    @Column(name = "CLIENT_ID")
    private Long id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String phone;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Getter @Setter
    private String account;

    @Getter @Setter
    private BigDecimal discountPrice;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, String phone, String account, Address address, BigDecimal discountPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.account = account;
        this.address = address;
        this.discountPrice = discountPrice;
    }

}
