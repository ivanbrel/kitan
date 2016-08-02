package by.ibrel.kitan.logic.service.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by ibrel on 13/05/16.
 *
 */
@EqualsAndHashCode
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

}
