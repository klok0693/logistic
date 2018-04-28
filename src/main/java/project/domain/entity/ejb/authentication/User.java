package project.domain.entity.ejb.authentication;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by klok on 10.1.18.
 */
@NotNullByDefault

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"username", "password"})
public class User implements UserDetails, Entity {
    private volatile int id;

    @Size(min = 2, max = 100,         message="field must be between 2 and 100 characters long.")
    @Pattern(regexp="[a-zA-Z0-9]+&",  message="field must be alphanumeric")
    private volatile String username, password;

    private volatile boolean isAccountNonExpired,
                             isAccountNonLocked,
                             isCredentialsNonExpired,
                             isEnabled;

    private volatile Set<Roles> authorities;

    //getters and setters for hibernate
    public boolean getIsAccountNonExpired(){return this.isAccountNonExpired;}
    public void setIsAccountNonExpired(boolean value){this.isAccountNonExpired = value;}

    public boolean getIsAccountNonLocked(){return this.isAccountNonLocked;}
    public void setIsAccountNonLocked(boolean value){this.isAccountNonLocked = value;}

    public boolean getIsCredentialsNonExpired(){return this.isCredentialsNonExpired;}
    public void setIsCredentialsNonExpired(boolean value){this.isCredentialsNonExpired = value;}

    public boolean getIsEnabled(){return this.isEnabled;}
    public void setIsEnabled(boolean value){this.isEnabled = value;}

    //userDetails implementation
    public boolean isAccountNonExpired(){return this.isAccountNonExpired;}
    public boolean isAccountNonLocked(){return this.isAccountNonLocked;}
    public boolean isCredentialsNonExpired(){return this.isCredentialsNonExpired;}
    public boolean isEnabled(){return this.isEnabled;}

    @JsonManagedReference(value = "UserAuthorities")
    public Set<Roles> getAuthorities(){return this.authorities;}
}
