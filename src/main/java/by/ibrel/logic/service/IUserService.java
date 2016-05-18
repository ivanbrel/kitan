package by.ibrel.logic.service;

import by.ibrel.logic.entity.User;
import by.ibrel.logic.exception.LoginExistsException;

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
