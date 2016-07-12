package by.ibrel.kitan.logic.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by ibrel on 13/05/16.
 */

@Entity
@Table(name = "product", schema ="main")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private Long id;

    private String nameProduct;

    private String model;

    private String color;

    private String countryProduct;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Price price;

    private String barcode;

    private String category;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.REMOVE)
    private Collection<Purchase> purchases;

    //check the status of the product, if true means free
    private boolean state;

    //check the status of the product, if true means product sales
    private boolean sales;

    private Integer count;

    @Column(name = "new_column")
    @ElementCollection
    private List<String> newColumn;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private InfoPurchaseProduct infoPurchaseProduct;

    public Product() {
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
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

    public Collection<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Collection<Purchase> purchases) {
        this.purchases = purchases;
    }

    public String getCountryProduct() {
        return countryProduct;
    }

    public void setCountryProduct(String countryProduct) {
        this.countryProduct = countryProduct;
    }

    public boolean isSales() {
        return sales;
    }

    public void setSales(boolean sales) {
        this.sales = sales;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(List<String> newColumn) {
        this.newColumn = newColumn;
    }

    public InfoPurchaseProduct getInfoPurchaseProduct() {
        return infoPurchaseProduct;
    }

    public void setInfoPurchaseProduct(InfoPurchaseProduct infoPurchaseProduct) {
        this.infoPurchaseProduct = infoPurchaseProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(id);
        return builder.toString();
    }
}
