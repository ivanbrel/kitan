package by.ibrel.kitan.web.controllers.auth;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.exception.auth.UserAlreadyExistException;
import by.ibrel.kitan.logic.service.auth.dto.UserDto;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import by.ibrel.kitan.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static by.ibrel.kitan.Const.LOGIN_EXISTS_CHECK;
import static by.ibrel.kitan.Const.REGISTRATION_URL;

/**
 * @author ibrel
 * @version 1.1 (26.06.2016)
 */

@Controller
public class RegistrationController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IUserService userService;
    private AuthenticationProvider provider;

    @Autowired
    public RegistrationController(IUserService userService,@Qualifier("myAuthProvider") AuthenticationProvider provider) {
        this.userService = userService;
        this.provider = provider;
    }

    // Registration

    @RequestMapping(value = REGISTRATION_URL, method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse registerUser(@Valid final UserDto userDto, HttpServletRequest request){
        LOGGER.debug("Registering user account with information: {}" + userDto);

        final User registered = userService.create(userDto);
        if (registered==null){
            throw new UserAlreadyExistException();
        }

        doAutoLogin(registered.getLogin(),userDto.getPassword(),request);

        return new GenericResponse("success");
    }

    @RequestMapping(value = LOGIN_EXISTS_CHECK, method = RequestMethod.POST)
    public @ResponseBody boolean handlerRequest(final HttpServletRequest request) throws Exception {

        User user = null;
        try {
            user = userService.findByLogin(request.getParameter("login"));
        }catch (Exception e){
            throw new Exception();
        }

        boolean flag = false;

        if (user==null) flag = true;

        return flag;
    }

    private void doAutoLogin(String username, String password, HttpServletRequest request) {

        try {
            // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = provider.authenticate(token);
            LOGGER.debug("Logging in with [{}]", authentication.getPrincipal());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
            LOGGER.error("Failure in autoLogin", e);
        }

    }
}
