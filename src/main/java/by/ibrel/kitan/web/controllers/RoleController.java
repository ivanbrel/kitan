package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.auth.dao.entity.Privilege;
import by.ibrel.kitan.auth.dao.entity.Role;
import by.ibrel.kitan.auth.exception.RoleExistsException;
import by.ibrel.kitan.auth.exception.UserAlreadyExistException;
import by.ibrel.kitan.auth.service.dto.RoleDto;
import by.ibrel.kitan.auth.service.impl.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ibrel on 05/07/16.
 */
@Controller
@RequestMapping("/")
public class RoleController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IRoleService service;

    //list all roles
    @RequestMapping(value = {"/role/list" }, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String listRoles(final ModelMap model) {

        List<Role> roles = service.findAllRoles();
        model.addAttribute("roles", roles);

        return "auth.role.list";
    }

    //add new role
    @RequestMapping(value = {"/role/add"}, method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String addRole(@Valid final RoleDto roleDto, final ModelMap model){

        LOGGER.debug("Add new role with name:" + roleDto);

        final Role add = createRole(roleDto);
        if (add==null){
            throw new UserAlreadyExistException();
        }
        model.addAttribute("success");

        return "redirect:/role/list";
    }

    private Role createRole(RoleDto roleDto) {

        Role add = null;
        try{
            add = service.addNewRole(roleDto);
        }catch (final RoleExistsException e){
            return null;
        }
        return add;
    }

    @RequestMapping(value = { "/role/delete/{id}" }, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String deleteUser(@PathVariable final Long id) {
        service.emptyRole(id);
        service.deleteRole(id);
        return "redirect:/role/list";
    }

    @RequestMapping(value = {"/role/edit/{name}"}, method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String updateRole(final Role role, final BindingResult result, final ModelMap map){

        if (result.hasErrors()){return "users.roles.edit";}
        service.editRole(role);
        map.addAttribute("success", "Роль " + role.getName() + " изменена");

        return "redirect:/role/list";
    }

    @RequestMapping(value = {"/role/edit/{name}"}, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String editRole(@PathVariable String name, final ModelMap map){

        Role r = service.findByName(name);
        map.addAttribute("role", r);


        List<Privilege> privileges = service.getAllPrivileges();
        map.addAttribute("privileges", privileges);

        return "auth.role.edit";
    }

}
