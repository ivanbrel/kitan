package by.ibrel.logic.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ibrel on 13/05/16.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID", unique = true, nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Collection<Product> products;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        return account.equals(client.account);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + account.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                ", product=" + products +
                '}';
    }
}
