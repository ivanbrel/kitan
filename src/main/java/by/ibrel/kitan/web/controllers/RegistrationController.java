package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.service.impl.IUserService;
import by.ibrel.kitan.auth.service.UserDto;
import by.ibrel.kitan.auth.exception.LoginExistsException;
import by.ibrel.kitan.auth.exception.UserAlreadyExistException;
import by.ibrel.kitan.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    public RegistrationController() {
        super();
    }

    // Registration

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse registerUser(@Valid final UserDto userDto, final HttpServletRequest request){
        LOGGER.debug("Registering user account with information: {}" + userDto);

        final User registered = createUserAccount(userDto);
        if (registered==null){
            throw new UserAlreadyExistException();
        }
        return new GenericResponse("success");
    }

    private User createUserAccount(UserDto userDto) {

        User registered = null;
        try{
            registered = userService.registerNewUserAccount(userDto);
        }catch (final LoginExistsException e){
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

        if (user!=null) flag = true;

        return flag;
    }
}
