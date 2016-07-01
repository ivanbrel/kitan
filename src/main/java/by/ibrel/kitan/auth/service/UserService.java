package by.ibrel.kitan.auth.service;

import by.ibrel.kitan.auth.service.impl.IUserService;
import by.ibrel.kitan.auth.dao.repository.RoleRepository;
import by.ibrel.kitan.auth.dao.repository.UserRepository;
import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.exception.LoginExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ibrel on 08.04.2016.
 */

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //API

    @Override
    public User registerNewUserAccount(UserDto accountDto) throws LoginExistsException {
        if (loginExist(accountDto.getLogin())){
            throw new LoginExistsException("There is an account with that login: " + accountDto.getLogin());
        }
        final User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setLogin(passwordEncoder.encode(accountDto.getPassword()));
        user.setLogin(accountDto.getLogin());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return repository.save(user);
        
    }

    @Override
    public void saveRegisteredUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.delete(id);
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByUser(login);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        repository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public void updateUser(User user) {
        User entity = repository.findByUser(user.getLogin());
        if(entity!=null){
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
        }
        repository.save(entity);
    }

    private boolean loginExist(final String login){
        final User user = repository.findByUser(login);
        if (user!= null){
            return true;
        }
        return false;
    }
}
