package by.ibrel.logic.entity;

import javax.persistence.*;

/**
 * Created by ibrel on 13/05/16.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private Long id;

    private String nameProduct;

    private String model;

    private String color;

    private String countryProduct;

    private String price;

    private String barcode;

    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PURCHASE_ID", nullable = true)
    private Purchase purchase;

    //check the status of the product, if true means free
    private boolean state;

    //check the status of the product, if true means product sales
    private boolean sales;

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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
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
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", barcode=" + barcode +
                ", countryProduct=" + countryProduct +
                ", category=" + category +
                ", purchase=" + purchase +
                '}';
    }
}
