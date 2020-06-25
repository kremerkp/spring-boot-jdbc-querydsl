package lu.eyet.dev.jdbcsandbox.repository;

import org.springframework.data.repository.CrudRepository;

import lu.eyet.dev.jdbcsandbox.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}