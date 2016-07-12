package by.ibrel.kitan.auth.service.impl;

import by.ibrel.kitan.auth.dao.entity.User;
import by.ibrel.kitan.auth.exception.LoginExistsException;
import by.ibrel.kitan.auth.service.dto.UserDto;

import java.util.List;

/**
 * Created by ibrel on 08.04.2016.
 */
public interface IUserService  {

    User registerNewUserAccount(UserDto accountDto) throws LoginExistsException;

    void saveRegisteredUser(User user);

    void deleteUser(Long id);

    User findByLogin(String login);

    User getUserById(Long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    List<User> findAllUsers();

    void updateUser(User user);

}
