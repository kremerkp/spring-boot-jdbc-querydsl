package lu.eyet.dev.jdbcsandbox.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import lu.eyet.dev.jdbcsandbox.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    Iterable<Movie> findAll(Sort sort);

    Page<Movie> findAll(Pageable pageable);

}