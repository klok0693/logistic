package project.domain.entity.pojo.cargo;

import lombok.*;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.storehouse.StoreHouse;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    protected volatile int id, size;

    @Size(min = 2, max = 70,          message="field must be between 2 and 70 characters long.")
    @Pattern(regexp="[a-zA-Z0-9]+&",  message="field must be alphanumeric")
    protected volatile String type, format, name;

    protected volatile Date productionDate, shelfLife;

    protected volatile Client owner;
    protected volatile StoreHouse store;

    public AbstractCargo(String name) {
        this.name = name;
    }
}
