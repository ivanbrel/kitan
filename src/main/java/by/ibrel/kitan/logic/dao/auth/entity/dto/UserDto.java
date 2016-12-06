package by.ibrel.kitan.logic.dao.auth.entity.dto;

import by.ibrel.kitan.logic.validation.PasswordMatches;
import by.ibrel.kitan.logic.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author ibrel
 * @version 1.1 (08.04.2016)
 */
@ToString
@PasswordMatches
@Getter @Setter
public class UserDto implements Serializable{

    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @Size(min = 4)
    private String login;

    @NotNull
    @Size(min = 4)
    private String email;

    @NotNull
    @Size(min = 4)
    private String phone;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 8)
    private String matchingPassword;

    private List<String> roles;
}
