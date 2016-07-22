package by.ibrel.kitan.logic.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by ibrel on 19/07/16.
 *
 */
@EqualsAndHashCode
@Entity
@Table(name = "price")
public class PriceConvert implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Double rubleBY;

    @Getter @Setter
    private Double rubleRUS;

    @Getter @Setter
    private Double euro;

    @Getter @Setter
    private Double grivUA;

    @Getter @Setter
    private Double chinaUAN;

    @Getter @Setter
    private Double polandZLOT;

    @Getter @Setter
    private Double dollarUSA;

    @Override
    public String toString() {
        return "PriceConvert{" +
                "id=" + id +
                '}';
    }
}
