package by.ibrel.kitan.logic.service.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by ibrel on 28/06/16.
 */
public class PriceDto {

    @NotNull
    private String priceForProduct;

    @NotNull
    private Integer byRuble;

    @NotNull
    private Integer rusRuble;

    @NotNull
    private Integer usaDollar;

    public String getPriceForProduct() {
        return priceForProduct;
    }

    public void setPriceForProduct(String priceForProduct) {
        this.priceForProduct = priceForProduct;
    }

    public Integer getByRuble() {
        return byRuble;
    }

    public void setByRuble(Integer byRuble) {
        this.byRuble = byRuble;
    }

    public Integer getRusRuble() {
        return rusRuble;
    }

    public void setRusRuble(Integer rusRuble) {
        this.rusRuble = rusRuble;
    }

    public Integer getUsaDollar() {
        return usaDollar;
    }

    public void setUsaDollar(Integer usaDollar) {
        this.usaDollar = usaDollar;
    }
}
