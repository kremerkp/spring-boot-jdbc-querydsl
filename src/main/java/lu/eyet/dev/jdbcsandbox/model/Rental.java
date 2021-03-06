package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;
import java.time.Duration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
@EqualsAndHashCode
public class Rental implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Duration duration;
    private Integer price;

    public Rental(Duration duration, Integer price) {
        this.duration = duration;
        this.price = price;
    }

}