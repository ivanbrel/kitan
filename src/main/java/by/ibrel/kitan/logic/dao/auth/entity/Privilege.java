package by.ibrel.kitan.logic.dao.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ibrel on 07.04.2016.
 *
 */

@Entity
@Table(name = "privilege")
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
//    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege() {
    }

    public Privilege(final String name) {
        this.name = name;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Privilege privilege = (Privilege) obj;
        if (!name.equals(privilege.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
