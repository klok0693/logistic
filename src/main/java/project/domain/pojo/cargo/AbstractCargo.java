package project.domain.pojo.cargo;

import lombok.*;
import project.NotNullByDefault;
import project.domain.pojo.clients.Client;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * Base class for all cargo;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public abstract class AbstractCargo {
    protected int    id;
    protected String name;
    protected Date   productionDate;
    protected Date   shelfLife;
    protected Client owner;
    protected int    size;
    protected String format;

    @Override
    public String toString() {
        return name+" "+size+" "+ format +" "+ owner.getName() +" "+productionDate+" "+shelfLife;
    }
}
