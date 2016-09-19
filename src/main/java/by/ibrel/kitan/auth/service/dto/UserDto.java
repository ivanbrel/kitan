package by.ibrel.kitan.auth.service.dto;

import by.ibrel.kitan.auth.validation.PasswordMatches;
import by.ibrel.kitan.auth.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author ibrel
 * @version 1.1 (08.04.2016)
 */
@ToString
@PasswordMatches
public class UserDto {

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String firstName;

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String lastName;

    @NotNull
    @Size(min = 4)
    @Getter @Setter
    private String login;

    @NotNull
    @Size(min = 4)
    @Getter @Setter
    private String email;

    @NotNull
    @Size(min = 4)
    @Getter @Setter
    private Integer phone;

    @ValidPassword
    @Getter @Setter
    private String password;

    @NotNull
    @Size(min = 8)
    @Getter @Setter
    private String matchingPassword;

    @Getter @Setter
    private Integer role;
}
