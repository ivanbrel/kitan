package by.ibrel.logic.service;

import by.ibrel.logic.validation.PasswordMatches;
import by.ibrel.logic.validation.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ibrel on 08.04.2016.
 */
@PasswordMatches
public class UserDto {

    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @Size(min = 4)
    private String login;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 8)
    private String matchingPassword;

    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(final Integer role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [firstName=").append(firstName).append("]").append("[lastName=").append(lastName).append("]").append("[login").append(login).append("]").append("[password").append(password).append("]");
        return builder.toString();
    }
}
