package by.ibrel.kitan.config.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author ibrel
 * @version ${version} (12.09.2016)
 */

public class UserWeb extends org.springframework.security.core.userdetails.User {

    /**
     * This class extends org.springframework.security.core.userdetails.User
     * the class to add to the object "principal"
     * field "user" by.ibrel.kitan.logic.dao.auth.entity.User class
     */
    private by.ibrel.kitan.logic.dao.auth.entity.User user;

    public UserWeb(String username, String password, Collection<? extends GrantedAuthority> authorities, by.ibrel.kitan.logic.dao.auth.entity.User user) {
        super(username, password, authorities);
        this.user=user;
    }

    public UserWeb(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, by.ibrel.kitan.logic.dao.auth.entity.User user) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public by.ibrel.kitan.logic.dao.auth.entity.User getUser() {
        return user;
    }

    public void setUser(by.ibrel.kitan.logic.dao.auth.entity.User user) {
        this.user = user;
    }
}