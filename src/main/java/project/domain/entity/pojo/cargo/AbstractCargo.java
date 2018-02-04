package project.domain.entity.pojo.cargo;

import lombok.*;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;

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
    protected volatile int    id;
    protected volatile String name;
    protected volatile Date   productionDate;
    protected volatile Date   shelfLife;
    protected volatile Client owner;
    protected volatile int    size;
    protected volatile String format;
}
