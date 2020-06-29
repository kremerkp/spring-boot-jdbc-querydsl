package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Author implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String name;

    public Author() {
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + "}";
    }

}