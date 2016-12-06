package by.ibrel.kitan.logic.service.auth;

import by.ibrel.kitan.constants.Const;
import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.dao.auth.entity.dto.UserDto;
import by.ibrel.kitan.logic.dao.auth.repository.UserRepository;
import by.ibrel.kitan.logic.dao.logic.entity.Image;
import by.ibrel.kitan.logic.exception.auth.LoginExistsException;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.auth.impl.IRoleService;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import by.ibrel.kitan.logic.service.logic.impl.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import static by.ibrel.kitan.constants.Const.DEFAULT_AVATAR;
/**
 * @author ibrel
 * @version 1.1 (08.04.2016)
 */

@Service
@PropertySource({"classpath:app.properties"})
public class UserService extends AbstractService<User> implements IUserService{

    private UserRepository repository;
    private IRoleService roleService;
    private PasswordEncoder passwordEncoder;
    private IImageService iImageService;
    private Environment environment;

    @Autowired
    public UserService(final UserRepository repository, final IRoleService roleService,
                       final PasswordEncoder passwordEncoder, final IImageService iImageService, Environment environment) {
        super(repository);
        this.repository=repository;
        this.roleService=roleService;
        this.passwordEncoder=passwordEncoder;
        this.iImageService=iImageService;
        this.environment = environment;
    }

    //API

    @Override
    public User findByLogin(String login) {
        return repository.findByUser(login);
    }

    @Override
    public void updateUserRole(UserDto userDto) {
        User user = findByLogin(userDto.getLogin());

        user.getRoles().clear();
        userDto.getRoles().forEach(r -> user.addRole(roleService.findByName(r)));

        save(user);
    }

    @Transactional
    public void changeUserPassword(Long id, String password) {
        User user = findOne(id);
        user.setPassword(passwordEncoder.encode(password));
        save(user);
    }

    @Override
    @Transactional
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

    @Transactional
    public void update(User user,  MultipartFile fileUpload){

        User entity = findByLogin(user.getLogin());
        if(entity!=null) {
            update(user);
            if (fileUpload!=null)
                iImageService.updateImage(entity.getImage(),fileUpload, environment.getProperty("fileImageAvatarPath"));
        }
        save(entity);
    }

    @Override
    @Transactional
    public User create(Object o) {

        UserDto userDto = (UserDto) o;

        Image image = new Image(DEFAULT_AVATAR,environment.getProperty("fileImageAvatarPath"));
        iImageService.save(image);

        if (loginExist(userDto.getLogin())){
            throw new LoginExistsException("There is an account with that login: " + userDto.getLogin());
        }
        User user = new User(userDto.getFirstName(),userDto.getLastName(),userDto.getLogin(),
                userDto.getEmail(),userDto.getPhone(),passwordEncoder.encode(userDto.getPassword()),image);
        user.addRole(roleService.findByName(Const.DEFAULT_ROLE));
        save(user);
        return user;
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
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public void delete(Long id) {
//        delete avatar user
        iImageService.deleteImage(findOne(id).getImage().getId());
        super.delete(id);
    }
}
