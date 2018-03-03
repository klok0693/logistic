package project.domain.entity.pojo.truck;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.aspect.NotNullByDefault;

/**
 * Created by klok on 12.10.17.
 * Base class for all trucks;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public abstract class AbstractTruck {
    //TODO:id=registerNumber?
    //TODO:remove trailer?
    protected volatile int          id;
    protected volatile int          registerNumber;
    protected volatile String       name,
                                    model,
                                    trailer;
    //protected volatile Organization organization;

    //@Getter @Setter protected Set<Cargo> cargo;

    protected AbstractTruck(String name) {
        this.name = name;
    }

    protected AbstractTruck(
                            int id,
                            int registerNumber,
                            String name,
                            String model,
                            String trailer)
    {
        this.id              = id;
        this.registerNumber  = registerNumber;
        this.name            = name;
        this.model           = model;
        this.trailer         = trailer;
        //this.organization    = organization;
    }
}
