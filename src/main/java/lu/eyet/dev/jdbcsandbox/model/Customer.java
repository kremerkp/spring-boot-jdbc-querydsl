package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Getter;

@Getter
public class Customer implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Long customer_id;
    private String name;
    private Address address;

    public Customer(Long customer_id, String name, Address address) {
        this.customer_id = customer_id;
        this.name = name;
        this.address = address;
    }

    public static Customer create(String name, Address address) {
        return new Customer(null, name, address);
    }

    @Override
    public String toString() {
        return "{" + " customer_id='" + customer_id + "'" + ", name='" + name + "'" + ", address='" + address + "'"
                + "}";
    }

}