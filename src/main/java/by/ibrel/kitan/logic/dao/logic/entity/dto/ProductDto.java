package by.ibrel.kitan.logic.dao.logic.entity.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by ibrel on 13/05/16.
 *
 */
@ToString
@Getter @Setter
public class ProductDto implements Serializable{

    @NotNull
    @Size(min = 1)
    private String nameProduct;

    @NotNull
    @Size(min = 1)
    private String model;

    @NotNull
    @Size(min = 1)
    private String color;

    @NotNull
    @Size(min = 1)
    private String countryProduct;

    @NotNull
    @Size(min = 1)
    private String category;

    @NotNull
    @Size(min = 1)
    private String pricebyn;

    @NotNull
    @Size(min = 1)
    private String priceRus;

    @NotNull
    @Size(min = 1)
    private String priceUsd;

    @NotNull
    @Size(min = 1)
    private String brand;

    @NotNull
    private String quantity;

    public Integer quantityConvert(String value){
        return Integer.parseInt(value);
    }
}
