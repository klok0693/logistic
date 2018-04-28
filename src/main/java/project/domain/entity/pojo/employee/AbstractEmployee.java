package project.domain.entity.pojo.employee;

import lombok.*;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.organization.Organization;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    protected volatile int id;

    @Size(min = 2, max = 70,         message="field must be between 2 and 70 characters long.")
    @Pattern(regexp="[a-zA-Z0-9]+&", message="field must be alphanumeric")
    protected volatile String type, name, surname, position;

    protected volatile Organization organization;

    protected AbstractEmployee(String name) {
        this.name = name;
    }
}
