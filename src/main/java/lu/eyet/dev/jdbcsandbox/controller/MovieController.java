package lu.eyet.dev.jdbcsandbox.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lu.eyet.dev.jdbcsandbox.model.Movie;
import lu.eyet.dev.jdbcsandbox.repository.MovieRepository;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping(path = "movies")
    public Page<Movie> getMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @GetMapping("/movie/{movieId}")
    public Optional<Movie> getMovie(@PathVariable Long movieId) {
        return movieRepository.findById(movieId);
    }

    @PostMapping(path = "addMovie", consumes = "application/json", produces = "application/json")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

}