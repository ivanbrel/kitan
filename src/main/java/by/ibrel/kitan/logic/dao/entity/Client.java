package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

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
    private String account;

    @Getter @Setter
    private Double discountPrice;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, String phone, String account, Double discountPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.account = account;
        this.discountPrice = discountPrice;
    }

}
