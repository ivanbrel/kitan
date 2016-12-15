package by.ibrel.kitan.web.controllers.auth;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.dao.auth.entity.dto.UserDto;
import by.ibrel.kitan.logic.exception.auth.UserAlreadyExistException;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import static by.ibrel.kitan.constants.Const.DEFAULT_PASS;
import static by.ibrel.kitan.constants.PageConstants.USER_EDIT_PAGE;
import static by.ibrel.kitan.constants.PageConstants.USER_LIST_PAGE;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (23.11.2016)
 * @datechange (23.11.2016)
 */
@Controller
@RequestMapping("/admin/user")
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public class UserAdminController{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IUserService userService;

    @Autowired
    public UserAdminController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return USER_LIST_PAGE;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateUser(@Valid final User user, BindingResult result, ModelMap model,
                             @ModelAttribute("fileUpload") MultipartFile fileUpload) {
        if (result.hasErrors()) return USER_EDIT_PAGE;
        userService.update(user,fileUpload);
        LOGGER.debug("Update user : " + user.getLogin());
        return USER_EDIT_PAGE;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String initFormForEditUser(@PathVariable Long id, ModelMap model) {
        model.addAttribute("user", userService.findOne(id));
        return USER_EDIT_PAGE;
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id, ModelMap modelMap) {
        try {
            userService.delete(id);
            LOGGER.debug("Delete user with id : " + id);
        }catch (Exception e){
            modelMap.addAttribute("fail", true);
            return listUsers(modelMap);
        }
        return listUsers(modelMap);
    }

    @RequestMapping(value = {"/reset-password/{id}"}, method = RequestMethod.GET)
    public String changePassword(@PathVariable Long id, ModelMap model) {
        userService.changeUserPassword(id, DEFAULT_PASS);
        LOGGER.debug("Password for user reset: " + id);
        return listUsers(model);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createUser(@Valid final UserDto userDto, ModelMap modelMap){

        if (userService.findByLogin(userDto.getLogin())!=null) throw new UserAlreadyExistException();

        userService.create(userDto);
        LOGGER.debug("Registering user account with information: {" + userDto +" }");
        return listUsers(modelMap);
    }
}