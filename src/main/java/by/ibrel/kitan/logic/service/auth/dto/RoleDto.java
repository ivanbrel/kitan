package by.ibrel.kitan.logic.service.auth.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class RoleDto implements Serializable{
    private String name;
}
