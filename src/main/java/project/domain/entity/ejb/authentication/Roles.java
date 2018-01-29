package project.domain.entity.ejb.authentication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import project.NotNullByDefault;

import java.util.Set;

/**
 * Created by klok on 10.1.18.
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@NotNullByDefault
public class Roles implements GrantedAuthority {
    private int id;
    private String name;
    private Set<User> users;

    @JsonBackReference
    public Set<User> getUsers(){
        return this.users;
    }

    @Override
    public String getAuthority() {
        return this.toString();
    }

}
