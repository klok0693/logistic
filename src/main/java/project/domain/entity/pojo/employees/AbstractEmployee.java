package project.domain.entity.pojo.employees;

import lombok.*;
import project.NotNullByDefault;
import project.domain.entity.pojo.organizations.Organization;

/**
 * Created by klok on 11.10.17.
 * Base class for all employee;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public abstract class AbstractEmployee {
    protected int          id;
    protected String       name;
    protected String       surname;
    protected String       position;
    protected Organization organization;

    @Override
    public String toString() {
        return surname+" "+name+" "+position+" "+organization.getName();
    }
}
