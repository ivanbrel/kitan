package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.service.impl.IUserService;
import by.ibrel.kitan.auth.exception.InvalidOldPasswordException;
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
import java.util.List;

import static by.ibrel.kitan.logic.Const.DEFAULT_PASS;
import static by.ibrel.kitan.logic.Const.PRODUCT_PATH;

/**
 * Created by ibrel on 20.04.2016.
 *
 */
@Controller
@RequestMapping("/")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/users/list"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "auth.user.list";
    }

    @RequestMapping(value = {"/user/edit/{user}"}, method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String updateUser(@Valid final User user, @Valid final String login, BindingResult result, ModelMap model, @ModelAttribute("fileUpload") MultipartFile fileUpload) {

        if (result.hasErrors()) {
            return "auth.user.edit";
        }

        userService.update(user,fileUpload);

        model.addAttribute("success", "Данные пользователя " + user.getLogin() + " изменены");
        return "auth.user.edit";
    }

    @RequestMapping(value = {"/user/edit/{user}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String editUser(@PathVariable String user, ModelMap model) {
        User u = userService.findByLogin(user);
        model.addAttribute("user", u);
        model.addAttribute("edit", true);
        return "auth.user.edit";
    }

    @RequestMapping(value = {"/user/delete/{id}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "auth.user.list";
    }

    @RequestMapping(value = {"/update/password"}, method = RequestMethod.POST)
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

    @RequestMapping(value = {"/user/change-password/{user}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String changePassword(@PathVariable String user, ModelMap model) {
        User u = userService.findByLogin(user);
        userService.changeUserPassword(u, DEFAULT_PASS);
        model.addAttribute("success", "Данные пользователя " + u.getLogin() + " изменены");
        return "redirect:/users/list";
    }

    //for common user
    @RequestMapping(value = {"/user/edit"}, method = RequestMethod.GET)
    public String editCommonUser( ModelMap model) {

        final User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "auth.user.edit";
    }

    //for common user
    @RequestMapping(value = { "/user/edit" }, method = RequestMethod.POST)
    public String updateCommonUser(@Valid final User user, final BindingResult result,
                                   final ModelMap model, @ModelAttribute("fileUpload") MultipartFile fileUpload){

        if (result.hasErrors()) {
            LOGGER.debug(result.toString());
        }

        userService.update(user,fileUpload);

        return editCommonUser(model);
    }

}