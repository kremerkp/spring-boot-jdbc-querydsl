package lu.eyet.dev.jdbcsandbox.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table(value = "user_roles")
@Data
public class RoleRef {

    Long role;

    public RoleRef(Long role) {
        this.role = role;
    }

    public RoleRef() {
    }

}