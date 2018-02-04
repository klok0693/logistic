package project.domain.entity.pojo.truck;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organization.Organization;

import java.util.List;

/**
 * Created by klok on 12.10.17.
 * Base class for all trucks;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@Getter @Setter
@EqualsAndHashCode(exclude = {"id", "cargo"})
public abstract class AbstractTruck<V extends Cargo<V>> {
    //TODO:id=registerNumber?
    //TODO:remove trailer?
    protected volatile int          id;
    protected volatile int          registerNumber;
    protected volatile String       model;
    protected volatile String       trailer;
    protected volatile Organization organization;

    @Getter @Setter protected List<V>      cargo;

    public AbstractTruck() {}

    public AbstractTruck(int id, String model, Organization organization, String trailer, int registerNumber) {
        this.id              = id;
        this.model           = model;
        this.organization    = organization;
        this.trailer         = trailer;
        this.registerNumber  = registerNumber;
    }
}
