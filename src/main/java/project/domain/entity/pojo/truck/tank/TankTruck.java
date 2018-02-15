package project.domain.entity.pojo.truck.tank;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.oil.Oil;
import project.domain.entity.pojo.organization.Organization;
import project.domain.entity.pojo.truck.AbstractTruck;

import java.util.List;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class TankTruck extends AbstractTruck<Oil> implements Tank {

    public TankTruck() {
        super("TankTruck");
    }

    public TankTruck(int id, int registerNumber, String model, String trailer, Organization organization) {
        super(id, registerNumber, "TankTruck", model, trailer, organization);
    }

    @Override
    public void loadCargo(List<Oil> cargo) {
        this.cargo = cargo;
    }

    @Override
    public List<Oil> takeCargo() {
        return cargo;
    }

    @Override
    public Tank newInstance() {
        return new TankTruck();
    }
}
