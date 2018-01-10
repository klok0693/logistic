package project.domain.entity.ejb.user;

import org.springframework.security.core.GrantedAuthority;
import project.NotNullByDefault;

/**
 * Created by klok on 10.1.18.
 */
@NotNullByDefault
public enum Roles implements GrantedAuthority {

    user, admin;

    @Override
    public String getAuthority() {
        return this.toString();
    }

}
