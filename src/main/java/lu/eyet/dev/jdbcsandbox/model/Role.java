package lu.eyet.dev.jdbcsandbox.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = { "role_id" })
@AllArgsConstructor
@EqualsAndHashCode
public class Role {

    @Id
    private Long role_id;

    private String name;

}