package lu.eyet.dev.jdbcsandbox.model;

import java.util.HashSet;
import java.util.Set;

import com.mysema.commons.lang.Assert;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class User {

    @Id
    private Long user_id;

    private String email;

    private String password;

    private String name;

    private Boolean islogin;

    private Set<RoleRef> userRoles = new HashSet<>();

    public void addRoleRef(Role role) {
        this.userRoles.add(createRoleRef(role));

    }

    private RoleRef createRoleRef(Role role) {
        Assert.notNull(role, "Role must not set to null");
        Assert.notNull(role.getRole_id(), "Role-ID must not set to null");
        return new RoleRef(role.getRole_id());

    }

}