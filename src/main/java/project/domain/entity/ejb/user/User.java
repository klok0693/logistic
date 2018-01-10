package project.domain.entity.ejb.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.NotNullByDefault;

import java.util.Set;

/**
 * Created by klok on 10.1.18.
 */
@Data
@NoArgsConstructor
@NotNullByDefault
public class User implements UserDetails {
    private int userId;
    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Set<GrantedAuthority> authorities;
}
