package project.domain.pojo.truck.tank;

import project.NotNullByDefault;
import project.domain.pojo.cargo.oil.Oil;
import project.domain.pojo.organizations.Organization;
import project.domain.pojo.truck.AbstractTruck;

import java.util.List;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
class TankTruck extends AbstractTruck<Oil> implements Tank {

    public TankTruck() {}

    public TankTruck(int id, String model, Organization organization, String trailer, int registerNumber) {
        super(id, model, organization, trailer, registerNumber);
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
