package by.ibrel.kitan.logic.service.logic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ibrel on 13/05/16.
 *
 */
@ToString
@Getter@Setter
public class ClientDto implements Serializable{

    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @Size(min = 1)
    private String email;

    @NotNull
    @Size(min = 1)
    private String phone;

    @NotNull
    @Size(min = 1)
    private String account;

    @NotNull
    @Size(min = 1)
    private BigDecimal discount;

    @NotNull
    @Size(min = 1)
    private String country;

    @NotNull
    @Size(min = 1)
    private String town;

    @NotNull
    @Size(min = 1)
    private String street;

    @NotNull
    @Size(min = 1)
    private Integer postCode;
}
