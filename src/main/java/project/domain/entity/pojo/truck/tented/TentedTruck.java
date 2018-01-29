package project.domain.entity.pojo.truck.tented;

import project.NotNullByDefault;
import project.domain.entity.pojo.cargo.box.Box;
import project.domain.entity.pojo.organizations.Organization;
import project.domain.entity.pojo.truck.AbstractTruck;

import java.util.List;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class TentedTruck extends AbstractTruck<Box> implements Tented {

    public TentedTruck() {}

    public TentedTruck(int id, String model, Organization organization, String trailer, int registerNumber) {
        super(id, model, organization, trailer, registerNumber);
    }

    @Override
    public void loadCargo(List<Box> cargo) {
        this.cargo = cargo;
    }

    @Override
    public List<Box> takeCargo() {
        return this.cargo;
    }

    @Override
    public TentedTruck newInstance() {
        return new TentedTruck();
    }
}
