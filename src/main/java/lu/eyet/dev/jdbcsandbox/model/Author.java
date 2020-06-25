package lu.eyet.dev.jdbcsandbox.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Author {

    @Id
    private Long id;
    private String name;
    private LocalDate birthDate;

    public Author() {
    }

    public Author(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Author id(Long id) {
        this.id = id;
        return this;
    }

    public Author name(String name) {
        this.name = name;
        return this;
    }

    public Author birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", birthDate='" + getBirthDate() + "'"
                + "}";
    }

}