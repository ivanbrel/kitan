package by.ibrel.kitan.logic.dao.auth.entity.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class RoleDto implements Serializable{
    private Long id;
    private String name;
    private List<String> privileges;
}
