package by.ibrel.kitan.logic.dao.auth.entity;

import by.ibrel.kitan.logic.dao.logic.entity.Image;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 *
 * @author ibrel
 * @version 1.3 (07.04.2016)
 */

@Entity
@Table(name = "USER", schema = "AUTH")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String login;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String phone;

    @Getter @Setter
    @Column(length = 60)
    private String password;

    @Getter
    @ManyToMany(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",schema = "AUTH",joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IMAGE_ID")
    private Image image;

    public User() {
        this.roles = new ArrayList<>();
    }

    public User(String firstName, String lastName, String login, String email, String phone, String password, Image image){
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = new ArrayList<>();
        this.image = image;
    }

    private void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        roles.add(role);
    }

    public void deleteRole(Role role){
        roles.remove(role);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
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
        final User user = (User) obj;
        if (!login.equals(user.login)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
