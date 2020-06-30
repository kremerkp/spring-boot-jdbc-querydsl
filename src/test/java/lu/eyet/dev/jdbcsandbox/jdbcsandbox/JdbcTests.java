package lu.eyet.dev.jdbcsandbox.jdbcsandbox;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

import lu.eyet.dev.jdbcsandbox.repository.AuthorRepository;
import lu.eyet.dev.jdbcsandbox.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JdbcTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void jdbcTest() {
        System.out.println(bookRepository.findAll());

        // Author at = new Author();
        // at.setName("Martin Walser");
        // authorRepository.save(at);

        // Author at2 = new Author();
        // at2.setName("Martin Walser 2");
        // authorRepository.save(at2);

        // Book book = new Book();
        // book.setTitle("Ein sterbender Mann");
        // book.setIsbn("12343");
        // book.addAuthor2(at);
        // book.addAuthor2(at2);

        // bookRepository.save(book);

    }

}