package project.domain.entity.ejb.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import project.NotNullByDefault;

/**
 * Created by klok on 10.1.18.
 */
@NotNullByDefault
public interface Authentication {

    @JsonIgnore
    User getUser();
    void setUser(User user);
}
