package by.ibrel.kitan.logic.service.logic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author ibrel
 * @version 1.0 (29/09/16)
 */
@Getter
@Setter
@ToString
public class PriceDto implements Serializable{

    private BigDecimal rubleBY;

    private BigDecimal rubleRUS;

    private BigDecimal euro;

    private BigDecimal grivUA;

    private BigDecimal chinaUAN;

    private BigDecimal polandZLOT;

}
