package lu.eyet.dev.jdbcsandbox.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("book_author")
public class AuthRef {

    public AuthRef(Long id) {
    }

    private Long author;

}
