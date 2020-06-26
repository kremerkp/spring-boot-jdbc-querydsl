package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Getter;

@Getter
public class Address implements Serializable {

    @Id
    private Long address_id;
    private String addressLine;

    public Address(String addressLine) {
        this.addressLine = addressLine;
    }

    public Address(Long address_id, String addressLine) {
        this.address_id = address_id;
        this.addressLine = addressLine;
    }

    @Override
    public String toString() {
        return "{" + " address_id='" + address_id + "'" + ", addressLine='" + addressLine + "'" + "}";
    }

}