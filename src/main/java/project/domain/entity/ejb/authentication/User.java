package project.domain.entity.ejb.authentication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.NotNullByDefault;

import java.util.Set;

/**
 * Created by klok on 10.1.18.
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"username", "password"})
@NotNullByDefault
public class User implements UserDetails {
    private int id;
    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Set<GrantedAuthority> authorities;

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
    @JsonBackReference
    public Set<GrantedAuthority> getAuthorities(){return this.authorities;}
}
