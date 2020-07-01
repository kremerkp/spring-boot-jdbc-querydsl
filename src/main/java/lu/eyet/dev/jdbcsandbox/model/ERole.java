package lu.eyet.dev.jdbcsandbox.model;

import java.util.HashMap;
import java.util.Map;

public enum ERole {

    ROLE_USER(1L), ROLE_MODERATOR(2L), ROLE_ADMIN(3L);

    private Long value;
    private static Map map = new HashMap<>();

    private ERole(Long value) {
        this.value = value;
    }

    static {
        for (ERole eRole : ERole.values()) {
            map.put(eRole.value, eRole);
        }
    }

    public static ERole valueOf(int eRole) {
        return (ERole) map.get(eRole);
    }

    public Long getValue() {
        return value;
    }

}