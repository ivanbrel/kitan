package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.service.impl.IUserService;
import by.ibrel.kitan.auth.exception.InvalidOldPasswordException;
import by.ibrel.kitan.web.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by ibrel on 20.04.2016.
 */
@Controller
@RequestMapping("/")
public class UserController {

    private final static String DEFAULT_PASS = "password";

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/users/list"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "auth.user.list";
    }

    @RequestMapping(value = {"/edit-user-{user}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User u, BindingResult result, ModelMap model, @PathVariable String user) {

        if (result.hasErrors()) {
            return "users.edit";
        }

        userService.updateUser(u);


        model.addAttribute("success", "Данные пользователя " + u.getLogin() + " изменены");
        return "users.edit";
    }

    @RequestMapping(value = {"/edit-user-{user}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String user, ModelMap model) {
        User u = userService.findByLogin(user);
        model.addAttribute("user", u);
        model.addAttribute("edit", true);
        return "users.edit";
    }

    @RequestMapping(value = {"/delete-user-{id}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "users.list";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String showUser(ModelMap model, Principal principal) {

        if (principal != null) {

            org.springframework.security.core.userdetails.User activeUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

            User u = userService.findByLogin(activeUser.getUsername());
            model.addAttribute("user", u);

            return "login.login";
        }
        return "login.login";
    }

    @RequestMapping(value = {"/updatePassword"}, method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse updateUserPassword(@RequestParam("password") final String password, @RequestParam("oldpassword") final String oldPassword) {
        final User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            throw new InvalidOldPasswordException();
        } else {
            userService.changeUserPassword(user, password);
            return new GenericResponse("success");
        }
    }

    @RequestMapping(value = {"/change-password-{user}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String changePassword(@PathVariable String user, ModelMap model) {
        User u = userService.findByLogin(user);
        userService.changeUserPassword(u, DEFAULT_PASS);
        model.addAttribute("success", "Данные пользователя " + u.getLogin() + " изменены");
        return "users.success";
    }

    @RequestMapping(value = {"/edit/user"}, method = RequestMethod.GET)
    public String editCommonUser( ModelMap model) {
        User u = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", u);
        model.addAttribute("edit", true);
        return "auth.user.edit";
    }
}