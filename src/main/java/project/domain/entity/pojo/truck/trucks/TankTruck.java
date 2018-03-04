package project.domain.entity.pojo.truck.trucks;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.oil.Oil;
import project.domain.entity.pojo.organization.Organization;
import project.domain.entity.pojo.truck.AbstractTruck;
import project.domain.entity.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class TankTruck extends AbstractTruck<Oil> {

    public TankTruck() {
        super("TankTruck");
    }

    public TankTruck(int id, int registerNumber, String model, String trailer, Organization organization) {
        super(id, registerNumber, "TankTruck", model, trailer, organization);
    }

    @Override
    public Truck<Oil> newInstance() {
        return new TankTruck();
    }
}
