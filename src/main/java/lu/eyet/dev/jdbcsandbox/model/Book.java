package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties
@EqualsAndHashCode(exclude = { "id" })
public class Book implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2L;
    @Id
    private Long id;
    private String isbn;
    private String title;
    private Set<AuthRef> authors = new HashSet<>();

    public void addAuthor(Author author) {
        this.authors.add(createAuthorRef(author));
    }

    public void addAuthor2(Author author) {
        this.authors.add(new AuthRef(author.getId()));
    }

    private AuthRef createAuthorRef(Author author) {

        Assert.notNull(author, "Author must not be null");
        Assert.notNull(author.getId(), "Author id, must not be null");

        AuthRef authorRef = new AuthRef();
        authorRef.author = author.getId();
        // TODO #1 test

        return authorRef;
    }

}