package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;
import java.time.Duration;

import lombok.Getter;

@Getter
public class Rental implements Serializable {
    private Duration duration;
    private Integer price;

    public Rental(Duration duration, Integer price) {
        this.duration = duration;
        this.price = price;
    }

}