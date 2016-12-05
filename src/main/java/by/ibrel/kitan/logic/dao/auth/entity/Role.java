package by.ibrel.kitan.logic.dao.auth.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ibrel on 07.04.2016.
 *
 */

@Entity
@Table(name = "ROLE", schema = "AUTH")
@EqualsAndHashCode
@ToString
@Getter @Setter
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_privileges", schema = "AUTH",joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    private String name;

    public Role() {
        this.privileges = new ArrayList<>();
    }

    public Role(final String name) {
        this.name = name;
        this.privileges = new ArrayList<>();
    }

    private void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    public void addPrivilege(Privilege privilege){
        privileges.add(privilege);
    }

    public void deletePrivilege(Privilege privilege){
        privileges.remove(privilege);
    }
}
