package project.domain.entity.pojo.truck.trucks;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.box.Box;
import project.domain.entity.pojo.organization.Organization;
import project.domain.entity.pojo.truck.AbstractTruck;
import project.domain.entity.pojo.truck.Truck;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class TentedTruck extends AbstractTruck<Box> {

    public TentedTruck() {
        super("TentedTruck");
    }

    public TentedTruck(int id, int registerNumber, String model, String trailer, Organization organization) {
        super(id, registerNumber, "TentedTruck", model, trailer, organization);
    }

    @Override
    public Truck<Box> newInstance() {
        return new TentedTruck();
    }
}
