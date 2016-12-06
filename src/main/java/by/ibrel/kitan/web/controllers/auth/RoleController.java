package by.ibrel.kitan.web.controllers.auth;

import by.ibrel.kitan.logic.dao.auth.entity.Privilege;
import by.ibrel.kitan.logic.dao.auth.entity.Role;
import by.ibrel.kitan.logic.exception.auth.UserAlreadyExistException;
import by.ibrel.kitan.logic.dao.auth.entity.dto.RoleDto;
import by.ibrel.kitan.logic.service.auth.impl.IPrivilegeService;
import by.ibrel.kitan.logic.service.auth.impl.IRoleService;
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

import static by.ibrel.kitan.constants.PageConstants.*;
/**
 * @author ibrel
 * @version 1.1 (26.06.2016)
 */

@Controller
@RequestMapping("/admin/role")
@PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
public class RoleController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IRoleService service;
    private IPrivilegeService privilegeService;

    @Autowired
    public RoleController(IRoleService service, IPrivilegeService privilegeService) {
        this.service = service;
        this.privilegeService = privilegeService;
    }

    @RequestMapping(value = {"/list" }, method = RequestMethod.GET)
    public String listRoles(final ModelMap modelMap) {
        List<Role> roles = service.findAll();
        modelMap.addAttribute("roles", roles);
        return ROLE_LIST_PAGE;
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String createRole(@Valid final RoleDto roleDto, final ModelMap modelMap){
        final Role role = service.create(roleDto);
        if (role == null) throw new UserAlreadyExistException();
        LOGGER.debug("Create new role with name: " + roleDto);
        return listRoles(modelMap);
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteRole(@PathVariable final Long id, final ModelMap modelMap) {
        service.emptyRole(id);
        service.delete(id);
        LOGGER.debug("Delete role with id: " + id);
        return listRoles(modelMap);
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateRole(final RoleDto roleDto, final BindingResult result, final ModelMap modelMap){

        if (result.hasErrors()){return ROLE_EDIT_PAGE;}
        service.update(roleDto);
        LOGGER.debug("Update role with name: " + roleDto.getName());
        return listRoles(modelMap);
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String initRoleForm(@PathVariable Long id, final ModelMap map){

        Role role = service.findOne(id);
        map.addAttribute("role", role);

        List<Privilege> privileges = privilegeService.findAll();
        map.addAttribute("privileges", privileges);

        return ROLE_EDIT_PAGE;
    }
}