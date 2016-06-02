package by.ibrel.logic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PURCHASE_ID", unique = true, nullable = false)
    private Long id;

    private Integer numberPurchase;

    private String date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "purchase")
    private Collection<Product> product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID", nullable = true)
    private Client client;

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

    public Collection<Product> getProduct() {
        return product;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "client=" + client +
                ", product=" + product +
                ", date=" + date +
                ", numberPurchase=" + numberPurchase +
                '}';
    }
}

