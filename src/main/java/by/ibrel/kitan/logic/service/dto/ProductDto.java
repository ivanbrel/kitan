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
public class ProductDto {

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String nameProduct;

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String model;

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String color;

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String countryProduct;

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String category;

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String price;

    @NotNull
    @Size(min = 1)
    @Getter @Setter
    private String barcode;

    @NotNull
    @Getter @Setter
    private String quantity;

    public Double priceConvert(String value){
        return Double.parseDouble(value);
    }

    public Integer quantityConvert(String value){
        return Integer.parseInt(value);
    }
}
