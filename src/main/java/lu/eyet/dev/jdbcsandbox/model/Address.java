package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
@EqualsAndHashCode
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Exclude
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