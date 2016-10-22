package by.ibrel.kitan.logic.dao.logic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ibrel
 * @version 1.0 (16/09/16)
 */
@Entity
@Table(name = "address")
public class Address implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Getter @Setter
    private String country;

    @Getter @Setter
    private String town;

    @Getter @Setter
    private String street;

    @Getter @Setter
    private Integer postCode;

    public Address() {
    }

    public Address(String country, String town, String street, Integer postCode) {
        this.country=country;
        this.town=town;
        this.street=street;
        this.postCode=postCode;
    }
}
