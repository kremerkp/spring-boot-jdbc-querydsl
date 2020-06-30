package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties
@EqualsAndHashCode
public class Author implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Exclude
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