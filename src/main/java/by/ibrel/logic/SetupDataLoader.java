package by.ibrel.logic;

import by.ibrel.logic.repository.PrivilegeRepository;
import by.ibrel.logic.repository.RoleRepository;
import by.ibrel.logic.repository.UserRepository;
import by.ibrel.logic.entity.Privilege;
import by.ibrel.logic.entity.Role;
import by.ibrel.logic.entity.User;
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
    private final Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    private final User createUserIfNotFound(final String name){

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