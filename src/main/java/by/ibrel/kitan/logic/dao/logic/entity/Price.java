package by.ibrel.kitan.logic.dao.logic.entity;

import by.ibrel.kitan.logic.dao.logic.entity.dto.PriceDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ibrel on 19/07/16.
 *
 */
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "price", schema = "LOGIC")
public class Price implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private BigDecimal rubleBY;

    @Getter @Setter
    private BigDecimal  rubleRUS;

    @Getter @Setter
    private BigDecimal  euro;

    @Getter @Setter
    private BigDecimal  grivUA;

    @Getter @Setter
    private BigDecimal  chinaUAN;

    @Getter @Setter
    private BigDecimal  polandZLOT;

    @Getter
    private final BigDecimal  dollarUSA = BigDecimal.ONE;

    public Price() {
    }

    public Price(BigDecimal rubleBy, BigDecimal rubleRus, BigDecimal euro, BigDecimal grivUa, BigDecimal chinaUan, BigDecimal polandZlot){
        this.rubleBY = rubleBy;
        this.rubleRUS = rubleRus;
        this.euro = euro;
        this.grivUA = grivUa;
        this.chinaUAN = chinaUan;
        this.polandZLOT = polandZlot;
    }

    public Price(PriceDto priceDto){
        this.rubleBY = priceDto.getRubleBY();
        this.rubleRUS = priceDto.getRubleRUS();
        this.euro = priceDto.getEuro();
        this.grivUA = priceDto.getGrivUA();
        this.chinaUAN = priceDto.getChinaUAN();
        this.polandZLOT = priceDto.getPolandZLOT();
    }

}
