package project.domain.entity.ejb.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

/**
 * Created by klok on 10.1.18.
 */
@NotNullByDefault
public interface Authentication extends Entity {

    @JsonIgnore
    User getUser();
    void setUser(User user);
}
