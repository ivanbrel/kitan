package by.ibrel.kitan.web.controllers.auth;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.exception.auth.InvalidOldPasswordException;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import by.ibrel.kitan.web.controllers.AbstractController;
import by.ibrel.kitan.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import static by.ibrel.kitan.Const.*;

/**
 * Created by ibrel on 20.04.2016.
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController<User>{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        super(userService);
        this.userService = userService;
    }

    @RequestMapping(value = {"/update-password"}, method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse updateUserPassword(@RequestParam("password") final String password, @RequestParam("oldPassword") final String oldPassword) {
        final User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            throw new InvalidOldPasswordException();
        } else {
            userService.changeUserPassword(user, password);
            return new GenericResponse("success");
        }
    }

    //for common user
    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String editCommonUser( ModelMap model) {
        final User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("entity",user);
        return USER_EDIT_PAGE;
    }

    //for common user
    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String updateCommonUser(@Valid final User user, final BindingResult result,
                                   final ModelMap model, @ModelAttribute("fileUpload") MultipartFile fileUpload){

        if (result.hasErrors()) {
            LOGGER.debug(result.toString());
        }

        userService.update(user,fileUpload);

        return editCommonUser(model);
    }

}