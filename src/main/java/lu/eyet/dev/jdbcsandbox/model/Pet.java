package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("pets")
public @Data class Pet implements Serializable {
    @Id
    private Long petId;
    private String name;
    private LocalDate birthDate;

    public Pet(Long petId, String name, LocalDate birthDate) {
        this.petId = petId;
        this.name = name;
        this.birthDate = birthDate;
    }

}