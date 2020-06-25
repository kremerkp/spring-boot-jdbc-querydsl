package lu.eyet.dev.jdbcsandbox.model;

import java.util.Set;

import org.springframework.data.annotation.Id;

public class Movie {

    @Id
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

    @Override
    public String toString() {
        return "{" + " movieId='" + movieId + "'" + ", title='" + title + "'" + ", description='" + description + "'"
                + ", rental='" + rental + "'" + "}";
    }

}