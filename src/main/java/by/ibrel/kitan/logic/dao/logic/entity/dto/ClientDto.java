package by.ibrel.kitan.logic.dao.logic.entity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ibrel on 13/05/16.
 *
 */
@ToString
@Getter@Setter
public class ClientDto implements Serializable{

    private String name;
    private String nameSiteOrShop;
    private String email;
    private String phone;
    private String workMode;
    private BigDecimal discountPrice;
    private String note;

}
