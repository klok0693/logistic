package project.domain.entity.pojo.employee;

import lombok.*;
import project.aspect.NotNullByDefault;

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
    protected volatile int          id;
    protected volatile String       type,
                                    name,
                                    surname,
                                    position;
    //protected volatile Organization organization;

    protected AbstractEmployee(String name) {
        this.name = name;
    }
}
