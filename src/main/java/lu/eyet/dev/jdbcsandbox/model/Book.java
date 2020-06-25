package lu.eyet.dev.jdbcsandbox.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private Set<AuthRef> authors = new HashSet<>();

    void addAuthor(Author author) {
        this.authors.add(new AuthRef(author.getId()));
    }

}