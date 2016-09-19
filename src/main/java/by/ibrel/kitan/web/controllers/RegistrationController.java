package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.service.impl.IUserService;
import by.ibrel.kitan.auth.service.dto.UserDto;
import by.ibrel.kitan.auth.exception.LoginExistsException;
import by.ibrel.kitan.auth.exception.UserAlreadyExistException;
import by.ibrel.kitan.logic.service.impl.IImageService;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;

import static by.ibrel.kitan.logic.Const.USER_PATH;

/**
 * @author ibrel
 * @version 1.1 (26.06.2016)
 */

@Controller
public class RegistrationController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Qualifier("authProvider")
    @Autowired
    private AuthenticationProvider provider;

    public RegistrationController() {
        super();
    }

    // Registration

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse registerUser(@Valid final UserDto userDto, HttpServletRequest request){
        LOGGER.debug("Registering user account with information: {}" + userDto);

        final User registered = createUserAccount(userDto);
        if (registered==null){
            throw new UserAlreadyExistException();
        }

        doAutoLogin(registered.getLogin(),userDto.getPassword(),request);

        return new GenericResponse("success");
    }

    private User createUserAccount(UserDto userDto) {

        User registered = null;
        try{
            registered = userService.registerNewUserAccount(userDto);
        }catch (LoginExistsException e){
            return null;
        }
        return registered;
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
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
