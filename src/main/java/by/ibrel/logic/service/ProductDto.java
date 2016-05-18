package by.ibrel.logic.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ibrel on 13/05/16.
 */
public class ProductDto {

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
    private Integer price;

    @NotNull
    @Size(min = 1)
    private Integer barcode;

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountryProduct() {
        return countryProduct;
    }

    public void setCountryProduct(String countryProduct) {
        this.countryProduct = countryProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "nameProduct='" + nameProduct + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", countryProduct='" + countryProduct + '\'' +
                ", price=" + price +
                ", barcode=" + barcode +
                '}';
    }
}
