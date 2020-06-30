package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
@EqualsAndHashCode
public class Movie implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Exclude
    private Long movieId;
    private String title;
    private String description;

    private Set<Rental> rental;

    public Movie(Long movieId, String title, String description, Set<Rental> rental) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.rental = rental;
    }

    public void addRental(Rental rental) {
        this.rental.add(rental);
    }

    @CreatedDate
    private DateTime createDate;

    @LastModifiedDate
    private DateTime lastModifiedDate;

    @Override
    public String toString() {
        return "{" + " movieId='" + movieId + "'" + ", title='" + title + "'" + ", description='" + description + "'"
                + ", rental='" + rental + "'" + "}";
    }

}