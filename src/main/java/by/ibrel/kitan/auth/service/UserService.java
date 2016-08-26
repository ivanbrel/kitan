package by.ibrel.kitan.auth.service;

import by.ibrel.kitan.auth.service.dto.UserDto;
import by.ibrel.kitan.auth.service.impl.IRoleService;
import by.ibrel.kitan.auth.service.impl.IUserService;
import by.ibrel.kitan.auth.dao.repository.UserRepository;
import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.exception.LoginExistsException;
import by.ibrel.kitan.logic.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author ibrel
 * @version 1.1 (08.04.2016)
 */

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //API

    @Override
    public User registerNewUserAccount(UserDto accountDto) throws LoginExistsException {
        if (loginExist(accountDto.getLogin())){
            throw new LoginExistsException("There is an account with that login: " + accountDto.getLogin());
        }
        User user = new User(accountDto.getFirstName(),accountDto.getLastName(),accountDto.getLogin(),passwordEncoder.encode(accountDto.getPassword()));
        user.addRole(roleService.findByName(Const.DEFAULT_ROLE));
        save(user);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByUser(login);
    }

    @Override
    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    /**
     * Checks exist login
     *
     * @param login user login
     * @return if true, login exist
     */
    private boolean loginExist(final String login){
        return findByLogin(login) != null;
    }

    @Override
    public void save(User entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(User user) {
        User entity = findByLogin(user.getLogin());
        if(entity!=null){
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
        }
        save(entity);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }
}
