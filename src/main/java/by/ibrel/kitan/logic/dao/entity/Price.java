//package by.ibrel.kitan.logic.dao.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
///**
// * Created by ibrel on 28/06/16.
// */
//
//@Entity
//public class Price implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String priceForProduct;
//
//    private Double byRuble;
//
//    private Double rusRuble;
//
//    private Double usaDollar;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    public Price() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getPriceForProduct() {
//        return priceForProduct;
//    }
//
//    public void setPriceForProduct(String priceForProduct) {
//        this.priceForProduct = priceForProduct;
//    }
//
//    public Double getByRuble() {
//        return byRuble;
//    }
//
//    public void setByRuble(Double byRuble) {
//        this.byRuble = byRuble;
//    }
//
//    public Double getRusRuble() {
//        return rusRuble;
//    }
//
//    public void setRusRuble(Double rusRuble) {
//        this.rusRuble = rusRuble;
//    }
//
//    public Double getUsaDollar() {
//        return usaDollar;
//    }
//
//    public void setUsaDollar(Double usaDollar) {
//        this.usaDollar = usaDollar;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Price price = (Price) o;
//        return Objects.equals(id, price.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "Price{" +
//                "id=" + id +
//                ", byRuble=" + byRuble +
//                ", rusRuble=" + rusRuble +
//                ", usaDollar=" + usaDollar +
//                ", product=" + product +
//                '}';
//    }
//}
