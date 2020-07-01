package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Exclude
    private Long id;
    private String name;

}