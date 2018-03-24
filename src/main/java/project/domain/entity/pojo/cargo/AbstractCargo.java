package project.domain.entity.pojo.cargo;

import lombok.*;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.storehouse.StoreHouse;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * Base class for all cargo;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public abstract class AbstractCargo implements Cargo {
    protected volatile int    id,
                              size;
    protected volatile String type,
                              format,
                              name;
    protected volatile Date   productionDate,
                              shelfLife;

    protected volatile Client owner;
    protected volatile StoreHouse store;

    public AbstractCargo(String name) {
        this.name = name;
    }
}
