package lu.eyet.dev.jdbcsandbox.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("pets")
public class Pet {
    @Id
    private String petId;
    private String name;
    private LocalDate birthDate;

    void setPetId(String petId) {
        this.petId = petId;
    }

    public Pet(String petId, String name, LocalDate birthDate) {
        this.petId = petId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static Pet create(String name, LocalDate birthDate) {
        return new Pet(null, name, birthDate);
    }

    @Override
    public String toString() {
        return "Pet{" + " id=" + petId + ", name=" + name + ", birthDate=" + birthDate + "}";
    }

}