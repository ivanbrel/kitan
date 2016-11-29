package by.ibrel.kitan;

import by.ibrel.kitan.logic.dao.auth.entity.Privilege;
import by.ibrel.kitan.logic.dao.auth.entity.Role;
import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.dao.logic.entity.Image;
import by.ibrel.kitan.logic.service.auth.impl.IPrivilegeService;
import by.ibrel.kitan.logic.service.auth.impl.IRoleService;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import by.ibrel.kitan.logic.service.logic.impl.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by ibrel on 5.5.16.
 *
 */

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent>  {

    private boolean alreadySetup = false;

    private IUserService userService;
    private IRoleService roleService;
    private IPrivilegeService privilegeService;
    private PasswordEncoder passwordEncoder;
    private IImageService imageService;

    @Autowired
    public SetupDataLoader(IUserService userService, IRoleService roleService, IPrivilegeService privilegeService,
                           PasswordEncoder passwordEncoder, IImageService imageService) {
        this.userService = userService;
        this.roleService = roleService;
        this.privilegeService = privilegeService;
        this.passwordEncoder = passwordEncoder;
        this.imageService = imageService;
    }

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        final Privilege adminPrivilege = createPrivilegeIfNotFound("ADMIN_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege, adminPrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        // == create user
        createUserIfNotFound("admin");

        alreadySetup = true;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeService.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeService.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleService.findByName(name);
//        Privilege privilege = privilegeRepository.findByName("READ_PRIVILEGE");

        if (role == null) {
            role = new Role(name);

            privileges.forEach(role::addPrivilege);
            roleService.save(role);
        }
        return role;
    }

    @Transactional
    private User createUserIfNotFound(final String name){

        final Role adminRole = roleService.findByName("ROLE_ADMIN");
        User user = userService.findByLogin(name);
        if (user==null){

            Image image = new Image();
            imageService.save(image);

            user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setLogin("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.addRole(adminRole);
            user.setImage(image);

            userService.save(user);
        }
        return user;
    }

}