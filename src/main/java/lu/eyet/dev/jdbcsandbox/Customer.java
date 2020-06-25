package lu.eyet.dev.jdbcsandbox;

import org.springframework.data.annotation.Id;

public class Customer {

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