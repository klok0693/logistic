package project.domain.entity.ejb.authentication;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

/**
 * Created by klok on 10.1.18.
 */
@NotNullByDefault

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
public class Roles implements Entity {
    private volatile int id;
    private volatile String name;
    //protected volatile Set<User> users;

    /*@JsonBackReference(value = "AuthorityUsers")
    public Set<User> getUsers(){
        return this.users;
    }*/
}
