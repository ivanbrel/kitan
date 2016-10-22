package by.ibrel.kitan.web.controllers.auth;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.exception.auth.InvalidOldPasswordException;
import by.ibrel.kitan.logic.service.auth.UserService;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import by.ibrel.kitan.web.controllers.AbstractController;
import by.ibrel.kitan.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/")
public class UserController extends AbstractController<User>{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        super(userService);
        this.userService = userService;
    }

    @RequestMapping(value = {USER_LIST_URL}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String listUsers(ModelMap model) {
        return listEntity(model,USER_LIST_PAGE);
    }

    @RequestMapping(value = {USER_EDIT_URL + "/{id}"}, method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String updateUser(@Valid final User user, @Valid final String login, BindingResult result, ModelMap model,
                             @ModelAttribute("fileUpload") MultipartFile fileUpload) {

        if (result.hasErrors()) {
            return "auth.user.edit";
        }

        userService.update(user,fileUpload);

        model.addAttribute("success", "Данные пользователя " + user.getLogin() + " изменены");
        return USER_EDIT_PAGE;
    }

    @RequestMapping(value = {USER_EDIT_URL + "/{id}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String editUser(@PathVariable Long id, ModelMap model) {
        return initForm(id,model,null,USER_EDIT_PAGE);
    }

    @RequestMapping(value = {USER_DELETE_URL + "/{id}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String deleteUser(@PathVariable Long id, ModelMap modelMap) {
        return deleteEntity(id, modelMap,listUsers(modelMap));
    }

    @RequestMapping(value = {UPDATE_PASSWORD_URL}, method = RequestMethod.POST)
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

    @RequestMapping(value = {CHANGE_PASSWORD_URL + "/{user}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String changePassword(@PathVariable String user, ModelMap model) {
        User u = userService.findByLogin(user);
        userService.changeUserPassword(u, DEFAULT_PASS);
        model.addAttribute("success", "Данные пользователя " + u.getLogin() + " изменены");
        return "redirect:/users/list";
    }

    //for common user
    @RequestMapping(value = {USER_EDIT_URL}, method = RequestMethod.GET)
    public String editCommonUser( ModelMap model) {
        final User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return initForm(user.getId(),model,null,USER_EDIT_PAGE);
    }

    //for common user
    @RequestMapping(value = { USER_EDIT_URL }, method = RequestMethod.POST)
    public String updateCommonUser(@Valid final User user, final BindingResult result,
                                   final ModelMap model, @ModelAttribute("fileUpload") MultipartFile fileUpload){

        if (result.hasErrors()) {
            LOGGER.debug(result.toString());
        }

        userService.update(user,fileUpload);

        return editCommonUser(model);
    }

}