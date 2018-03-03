package project.domain.entity.pojo.truck.tank;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.truck.AbstractTruck;
import project.domain.entity.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class TankTruck extends AbstractTruck implements Truck {

    public TankTruck() {
        super("TankTruck");
    }

    public TankTruck(int id, int registerNumber, String model, String trailer) {
        super(id, registerNumber, "TankTruck", model, trailer);
    }

    /*@Override
    public void loadCargo(Set<Cargo> cargo) {
        this.cargo = cargo;
    }

    @Override
    public Set<Cargo> takeCargo() {
        return cargo;
    }*/

    @Override
    public Truck newInstance() {
        return new TankTruck();
    }
}
