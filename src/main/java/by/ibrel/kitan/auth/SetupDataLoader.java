package by.ibrel.kitan.auth;

import by.ibrel.kitan.auth.dao.repository.PrivilegeRepository;
import by.ibrel.kitan.auth.dao.repository.RoleRepository;
import by.ibrel.kitan.auth.dao.repository.UserRepository;
import by.ibrel.kitan.auth.dao.entity.Privilege;
import by.ibrel.kitan.auth.dao.entity.Role;
import by.ibrel.kitan.auth.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by ibrel on 5.5.16.
 *
 */

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
//        Privilege privilege = privilegeRepository.findByName("READ_PRIVILEGE");

        if (role == null) {
            role = new Role(name);

//            for (Privilege privilege:privileges){
//                //role.getPrivileges().add(privilegeRepository.findByName(privilege.getName()));
//                role.setPrivileges(Arrays.asList(privilegeRepository.findByName(privilege.getName())));
//            }
            role.setPrivileges(privileges);
            //role.setPrivileges(Arrays.asList(privilege));
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    private User createUserIfNotFound(final String name){

        final Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = userRepository.findByUser(name);
        if (user==null){
            user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setLogin("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setRoles(Arrays.asList(adminRole));
            userRepository.save(user);
        }
        return user;
    }

}