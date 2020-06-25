package lu.eyet.dev.jdbcsandbox.jdbcsandbox;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lu.eyet.dev.jdbcsandbox.model.Movie;
import lu.eyet.dev.jdbcsandbox.model.Rental;
import lu.eyet.dev.jdbcsandbox.repository.MovieRepository;

@SpringBootTest
public class JdbcOneToOneAndOneToManyTests {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void contextLoads() {
        Set<Rental> rentals = new HashSet<Rental>();
        rentals.add(new Rental(Duration.ofDays(1), 2));
        rentals.add(new Rental(Duration.ofDays(2), 3));
        rentals.add(new Rental(Duration.ofDays(5), 5));
        Movie movie = new Movie(null, "Pulp Fiction", "desc...", rentals);
        movieRepository.save(movie);
        System.out.println(movieRepository.findAll());
    }

}