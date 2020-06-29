package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table("pets")
@EqualsAndHashCode
@Data
public class Pet implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Exclude
    private Long petId;
    private String name;
    private LocalDate birthDate;

    @CreatedDate
    private DateTime createDate;

    @LastModifiedDate
    private DateTime lastModifiedDate;

    public Pet(Long petId, String name, LocalDate birthDate) {
        this.petId = petId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Pet() {
    }

}