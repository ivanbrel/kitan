package by.ibrel.kitan.logic.service.auth.impl;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.service.ICommonService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IUserService extends ICommonService<User> {

    void update(User user,  MultipartFile fileUpload);

    boolean checkIfValidOldPassword(User user, String oldPassword);

    void changeUserPassword(User user, String password);

    User findByLogin(String login);
}
