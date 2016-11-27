package by.ibrel.kitan.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (24.11.2016)
 * @datechange (24.11.2016)
 */
@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("CustomAuthenticationManager.authenticate");
        return authenticationProvider.authenticate(authentication);
    }

}
