package project.domain.entity.pojo.truck;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import project.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organizations.Organization;

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
    protected int          id;
    protected int          registerNumber;
    protected String       model;
    protected String       trailer;
    protected Organization organization;

    @Getter @Setter protected List<V>      cargo;

    public AbstractTruck() {}

    public AbstractTruck(int id, String model, Organization organization, String trailer, int registerNumber) {
        this.id              = id;
        this.model           = model;
        this.organization    = organization;
        this.trailer         = trailer;
        this.registerNumber  = registerNumber;
    }

    @Override
    public String toString() {
        return model+" "+registerNumber+" "+trailer+" "+organization.getName();
    }
}
