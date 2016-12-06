package by.ibrel.kitan.logic.service.auth.impl;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.service.ICommonService;
import by.ibrel.kitan.logic.dao.auth.entity.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IUserService extends ICommonService<User> {

    void update(User user,  MultipartFile fileUpload);

    boolean checkIfValidOldPassword(User user, String oldPassword);

    void changeUserPassword(Long id, String password);

    User findByLogin(String login);

    void updateUserRole(UserDto userDto);
}
