package project.domain.entity.pojo.truck.tented;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.box.Box;
import project.domain.entity.pojo.organization.Organization;
import project.domain.entity.pojo.truck.AbstractTruck;

import java.util.List;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class TentedTruck extends AbstractTruck<Box> implements Tented {

    public TentedTruck() {
        super("TentedTruck");
    }

    public TentedTruck(int id, int registerNumber, String model, String trailer, Organization organization) {
        super(id, registerNumber, "TentedTruck", model, trailer, organization);
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
