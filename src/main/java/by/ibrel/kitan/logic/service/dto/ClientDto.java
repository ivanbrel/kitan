package by.ibrel.kitan.logic.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ibrel on 13/05/16.
 *
 */
@ToString
public class ClientDto {

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String firstName;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String lastName;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String email;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String phone;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String account;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String discount;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String country;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String town;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private String street;

    @NotNull
    @Size(min = 1)
    @Getter@Setter
    private Integer postCode;
}
