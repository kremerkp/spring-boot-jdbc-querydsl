package lu.eyet.dev.jdbcsandbox.repository;

import org.springframework.data.repository.CrudRepository;

import lu.eyet.dev.jdbcsandbox.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
