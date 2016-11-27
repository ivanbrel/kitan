package by.ibrel.kitan.config.security;


import by.ibrel.kitan.logic.dao.auth.entity.Privilege;
import by.ibrel.kitan.logic.dao.auth.entity.Role;
import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private IUserService userService;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;

    public MyUserDetailsService() {
        super();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final String ip = getClientIp();
        if (loginAttemptService.isBlocked(ip)){
            throw new RuntimeException("blocked");
        }
        try {
            final User user = userService.findByLogin(username);
            if (username == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);
            }

            return new UserWeb(user.getLogin(), user.getPassword(),true,true,true,true,getAuthorities(user.getRoles()), user);
        }catch (final Exception e){
            throw new RuntimeException(e);
        }
    }

    public final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private final List<String> getPrivileges(final Collection<Role> roles) {
        final List<String> privileges = new ArrayList<String>();
        final List<Privilege> collection = new ArrayList<Privilege>();
        for (final Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    private String getClientIp() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader ==null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}