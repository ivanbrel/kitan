package by.ibrel.kitan.auth.service;

import by.ibrel.kitan.auth.service.dto.UserDto;
import by.ibrel.kitan.auth.service.impl.IRoleService;
import by.ibrel.kitan.auth.service.impl.IUserService;
import by.ibrel.kitan.auth.dao.repository.UserRepository;
import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.exception.LoginExistsException;
import by.ibrel.kitan.logic.Const;
import by.ibrel.kitan.logic.dao.entity.Image;
import by.ibrel.kitan.logic.service.impl.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static by.ibrel.kitan.logic.Const.PRODUCT_PATH;
import static by.ibrel.kitan.logic.Const.USER_PATH;

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

    @Autowired
    private IImageService iImageService;

    //API

    @Override
    public User registerNewUserAccount(UserDto accountDto) throws LoginExistsException {

        Image image = new Image();
        iImageService.save(image);

        if (loginExist(accountDto.getLogin())){
            throw new LoginExistsException("There is an account with that login: " + accountDto.getLogin());
        }
        User user = new User(accountDto.getFirstName(),accountDto.getLastName(),accountDto.getLogin(),
                accountDto.getEmail(),accountDto.getPhone(),passwordEncoder.encode(accountDto.getPassword()),image);
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
            entity.setEmail(user.getEmail());
            entity.setPhone(user.getPhone());
        }
        save(entity);
    }

    public void update(User user,  MultipartFile fileUpload){

        User entity = findByLogin(user.getLogin());
        if(entity!=null) {
            update(user);
            if (fileUpload!=null)
                iImageService.updateImage(entity.getImage(),fileUpload, USER_PATH);
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
