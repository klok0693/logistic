package project.domain.entity.pojo.truck.tented;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.truck.AbstractTruck;
import project.domain.entity.pojo.truck.Truck;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class TentedTruck extends AbstractTruck implements Truck {

    public TentedTruck() {
        super("TentedTruck");
    }

    public TentedTruck(int id, int registerNumber, String model, String trailer) {
        super(id, registerNumber, "TentedTruck", model, trailer);
    }

    /*@Override
    public void loadCargo(Set<Cargo> cargo) {
        this.cargo = cargo;
    }

    @Override
    public Set<Cargo> takeCargo() {
        return this.cargo;
    }*/

    @Override
    public TentedTruck newInstance() {
        return new TentedTruck();
    }
}
