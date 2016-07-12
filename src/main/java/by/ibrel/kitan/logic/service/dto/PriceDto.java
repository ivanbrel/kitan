package by.ibrel.kitan.logic.service.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by ibrel on 28/06/16.
 */
public class PriceDto {

    @NotNull
    private String priceForProduct;

    @NotNull
    private Double byRuble;

    @NotNull
    private Double rusRuble;

    @NotNull
    private Double usaDollar;

    public String getPriceForProduct() {
        return priceForProduct;
    }

    public void setPriceForProduct(String priceForProduct) {
        this.priceForProduct = priceForProduct;
    }

    public Double getByRuble() {
        return byRuble;
    }

    public void setByRuble(Double byRuble) {
        this.byRuble = byRuble;
    }

    public Double getRusRuble() {
        return rusRuble;
    }

    public void setRusRuble(Double rusRuble) {
        this.rusRuble = rusRuble;
    }

    public Double getUsaDollar() {
        return usaDollar;
    }

    public void setUsaDollar(Double usaDollar) {
        this.usaDollar = usaDollar;
    }
}
