package by.ibrel.kitan.logic.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PurchaseDto {

    @NotNull
    @Size(min = 1)
    private String date;

    @NotNull
    @Size(min = 1)
    private Long productId;

    @NotNull
    @Size(min = 1)
    private Long clientId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
