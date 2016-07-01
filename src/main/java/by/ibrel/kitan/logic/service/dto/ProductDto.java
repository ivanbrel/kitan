package by.ibrel.kitan.logic.service.dto;

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
    private String category;

    @NotNull
    @Size(min = 1)
    private String price;

    @NotNull
    @Size(min = 1)
    private String barcode;

    private String count;

    private String newAtrr;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNewAtrr() {
        return newAtrr;
    }

    public void setNewAtrr(String newAtrr) {
        this.newAtrr = newAtrr;
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
