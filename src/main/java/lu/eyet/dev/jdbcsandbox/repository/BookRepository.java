package lu.eyet.dev.jdbcsandbox.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import lu.eyet.dev.jdbcsandbox.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findAll(Sort sort);

    Page<Book> findAll(Pageable pageable);

}
