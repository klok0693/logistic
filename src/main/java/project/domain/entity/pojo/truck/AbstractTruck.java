package project.domain.entity.pojo.truck;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organization.Organization;

import java.util.Set;

/**
 * Created by klok on 12.10.17.
 * Base class for all trucks;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id", "cargo"})
public abstract class AbstractTruck<V extends Cargo> implements Truck<V> {
    //TODO:id=registerNumber?
    //TODO:remove trailer?
    protected volatile int          id;
    protected volatile int          registerNumber;
    protected volatile String       name,
                                    model,
                                    trailer;
    protected volatile Organization organization;

    @Getter @Setter protected Set<V> cargo;

    protected AbstractTruck(String name) {
        this.name = name;
    }

    protected AbstractTruck(
                            int id,
                            int registerNumber,
                            String name,
                            String model,
                            String trailer,
                            Organization organization)
    {
        this.id              = id;
        this.registerNumber  = registerNumber;
        this.name            = name;
        this.model           = model;
        this.trailer         = trailer;
        this.organization    = organization;
    }
}
