package project.domain.entity.ejb.authentication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

import java.util.Set;

/**
 * Created by klok on 10.1.18.
 */
@NotNullByDefault

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
public class Roles implements GrantedAuthority, Entity {
    private volatile int id;
    private volatile String name;
    protected volatile Set<User> users;

    @JsonBackReference(value = "AuthorityUsers")
    public Set<User> getUsers(){
        return this.users;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
