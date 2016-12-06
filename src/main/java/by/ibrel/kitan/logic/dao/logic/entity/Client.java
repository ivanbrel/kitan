package by.ibrel.kitan.logic.dao.logic.entity;

import by.ibrel.kitan.logic.dao.logic.entity.dto.ClientDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ibrel on 13/05/16.
 *
 */
@Entity
@Table(name = "client", schema = "LOGIC")
@EqualsAndHashCode
@ToString
@Getter@Setter
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID")
    private Long id;
    private String name;
    private String nameSiteOrShop;
    private String email;
    private String phone;
    private String workMode;
    private BigDecimal discountPrice;
    private String note;

    public Client() {
    }

    public Client(String name, String nameSiteOrShop, String email, String phone, String workMode,
                  BigDecimal discountPrice, String note) {
        this.name = name;
        this.nameSiteOrShop = nameSiteOrShop;
        this.email = email;
        this.phone = phone;
        this.workMode = workMode;
        this.discountPrice = discountPrice;
        this.note = note;
    }

    public Client(ClientDto clientDto){
        this.name = clientDto.getName();
        this.nameSiteOrShop = clientDto.getNameSiteOrShop();
        this.email = clientDto.getEmail();
        this.phone = clientDto.getPhone();
        this.workMode = clientDto.getWorkMode();
        this.discountPrice = clientDto.getDiscountPrice();
        this.note = clientDto.getNote();
    }
}
