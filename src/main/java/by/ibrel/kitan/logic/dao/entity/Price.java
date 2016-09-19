package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by ibrel on 19/07/16.
 *
 */
@EqualsAndHashCode
@Entity
@Table(name = "price")
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

    @Getter @Setter
    private BigDecimal  dollarUSA;

    public Price() {
    }

    public Price(BigDecimal rubleBy, BigDecimal rubleRus, BigDecimal euro, BigDecimal grivUa, BigDecimal chinaUan, BigDecimal polandZlot, BigDecimal dollarUsa){
        this.rubleBY = rubleBy;
        this.rubleRUS = rubleRus;
        this.euro = euro;
        this.grivUA = grivUa;
        this.chinaUAN = chinaUan;
        this.polandZLOT = polandZlot;
        this.dollarUSA = dollarUsa;

    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                '}';
    }
}
