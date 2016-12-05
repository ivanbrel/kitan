package by.ibrel.kitan.logic.dao.auth.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ibrel on 07.04.2016.
 *
 */

@Entity
@Table(name = "PRIVILEGE", schema = "AUTH")
@ToString
@EqualsAndHashCode
@Getter @Setter
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Privilege() {
    }

    public Privilege(final String name) {
        this.name = name;
    }
}
