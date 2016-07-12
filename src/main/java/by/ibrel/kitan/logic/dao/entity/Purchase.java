package by.ibrel.kitan.logic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "purchase", schema ="main")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PURCHASE_ID")
    private Long id;

    private Integer numberPurchase;

    private String date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "purchase_product", schema ="main", joinColumns = @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "PURCHASE_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID"))
    private Collection<Product> products;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Double priceSummary;

    public Integer countSummary;

    @OneToMany(mappedBy = "purchase")
    private Collection<InfoPurchaseProduct> infoPurchaseProducts;

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberPurchase() {
        return numberPurchase;
    }

    public void setNumberPurchase(Integer numberPurchase) {
        this.numberPurchase = numberPurchase;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> product) {
        this.products = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getPriceSummary() {
        return priceSummary;
    }

    public void setPriceSummary(Double priceSummary) {
        this.priceSummary = priceSummary;
    }

    public Collection<InfoPurchaseProduct> getInfoPurchaseProducts() {
        return infoPurchaseProducts;
    }

    public void setInfoPurchaseProducts(Collection<InfoPurchaseProduct> infoPurchaseProducts) {
        this.infoPurchaseProducts = infoPurchaseProducts;
    }

    public Integer getCountSummary() {
        return countSummary;
    }

    public void setCountSummary(Integer countSummary) {
        this.countSummary = countSummary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[PURCHASE_ID=").append(id).append("]");
        return builder.toString();
    }
}

