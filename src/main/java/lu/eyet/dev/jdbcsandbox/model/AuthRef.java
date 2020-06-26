package lu.eyet.dev.jdbcsandbox.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("book_author")
public @Data class AuthRef {

    Long author;

    public AuthRef(Long author) {
        this.author = author;
    }

    public AuthRef() {
    }

}
