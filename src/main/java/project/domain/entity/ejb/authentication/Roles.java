package project.domain.entity.ejb.authentication;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @Size(min = 2, max = 100,    message="field must be between 2 and 100 characters long.")
    @Pattern(regexp="[a-zA-Z]",  message="field must be alphabetic")
    private volatile String name;

    protected volatile Set<User> users;

    @JsonManagedReference(value = "UserRoles")
    public Set<User> getUsers(){
        return this.users;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
