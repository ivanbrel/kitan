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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "purchase")
    private Collection<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Integer priceSummary;

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

    public Integer getPriceSummary() {
        return priceSummary;
    }

    public void setPriceSummary(Integer priceSummary) {
        this.priceSummary = priceSummary;
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

