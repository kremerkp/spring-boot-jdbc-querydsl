package lu.eyet.dev.jdbcsandbox.jdbcsandbox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lu.eyet.dev.jdbcsandbox.controller.ReportService;
import lu.eyet.dev.jdbcsandbox.model.Author;
import lu.eyet.dev.jdbcsandbox.model.Book;
import lu.eyet.dev.jdbcsandbox.repository.AuthorRepository;
import lu.eyet.dev.jdbcsandbox.repository.BookRepository;
import lu.eyet.dev.jdbcsandbox.repository.MovieRepository;

@SpringBootTest
public class JdbcOneToOneAndOneToManyTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReportService reportService;

    @Test
    @Transactional
    public void contextLoads() {
        // Set<Rental> rentals = new HashSet<Rental>();
        // rentals.add(new Rental(Duration.ofDays(1), 2));
        // rentals.add(new Rental(Duration.ofDays(2), 3));
        // rentals.add(new Rental(Duration.ofDays(5), 5));
        // Movie movie = new Movie(null, "Pulp Fiction", "desc...", rentals);
        // movieRepository.save(movie);
        // System.out.println(movieRepository.findAll());

    }

    @Test
    public void testManyToMany() {

        Author at = new Author();
        at.setName("Martin Walser");
        authorRepository.save(at);

        Author at2 = new Author();
        at2.setName("Martin Walser 2");
        authorRepository.save(at2);

        Book book = new Book();
        book.setTitle("Ein sterbender Mann");
        book.setIsbn("12343");
        book.addAuthor2(at);
        book.addAuthor2(at2);

        bookRepository.save(book);

    }

}