package by.ibrel.kitan.auth.service.impl;

import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.exception.LoginExistsException;
import by.ibrel.kitan.auth.service.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ibrel
 * @version 1.1 (8.04.2016)
 */
public interface IUserService extends ICommonService<User>  {

    User registerNewUserAccount(UserDto accountDto) throws LoginExistsException;

    User findByLogin(String login);

    /**
     * Chance user password
     *
     * @param user object user
     * @param password old user password
     */
    void changeUserPassword(User user, String password);

    /**
     * Check match user password and entering password
     *
     * @param user object user
     * @param password entering user password
     * @return true if passwords match
     */
    boolean checkIfValidOldPassword(User user, String password);

    void update(User user,  MultipartFile fileUpload);

}
