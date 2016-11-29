package by.ibrel.kitan.web.controllers.auth;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.exception.auth.UserAlreadyExistException;
import by.ibrel.kitan.logic.service.auth.dto.UserDto;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import by.ibrel.kitan.web.controllers.AbstractController;
import by.ibrel.kitan.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;

import static by.ibrel.kitan.Const.*;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (23.11.2016)
 * @datechange (23.11.2016)
 */
@Controller
@RequestMapping("/user/admin")
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public class UserAdminController extends AbstractController<User>{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IUserService userService;

    @Autowired
    public UserAdminController(IUserService userService) {
        super(userService);
        this.userService = userService;
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("list", userService.findAll());
        return USER_LIST_PAGE;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateUser(@Valid final User user, @Valid final String login, BindingResult result, ModelMap model,
                             @ModelAttribute("fileUpload") MultipartFile fileUpload) {

        if (result.hasErrors()) {
            return "auth.user.edit";
        }

        userService.update(user,fileUpload);

        model.addAttribute("success", "Данные пользователя " + user.getLogin() + " изменены");
        return USER_EDIT_PAGE;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable Long id, ModelMap model) {
        return initForm(id,model,null,USER_EDIT_PAGE);
    }

    @RequestMapping(value = {USER_DELETE_URL + "/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id, ModelMap modelMap) {
        return deleteEntity(id, modelMap,listUsers(modelMap));
    }

    @RequestMapping(value = {CHANGE_PASSWORD_URL + "/reset-password/{user}"}, method = RequestMethod.GET)
    public String changePassword(@PathVariable String user, ModelMap model) {
        User u = userService.findByLogin(user);
        userService.changeUserPassword(u, DEFAULT_PASS);
        model.addAttribute("success", "Данные пользователя " + u.getLogin() + " изменены");
        return listUsers(model);
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    @ResponseBody
    public String registerUser(@Valid final UserDto userDto, ModelMap modelMap){

        if (userService.findByLogin(userDto.getLogin())!=null){
            throw new UserAlreadyExistException();
        }

        userService.create(userDto);

        LOGGER.debug("Registering user account with information: {}" + userDto);
        return listUsers(modelMap);
    }
}
