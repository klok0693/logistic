package project.domain.entity.pojo.truck.refrigerated;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.truck.AbstractTruck;
import project.domain.entity.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class RefrigeratedTruck extends AbstractTruck implements Truck {

    public RefrigeratedTruck() {
        super("RefrigeratedTruck");
    }

    public RefrigeratedTruck(int id, int registerNumber, String model, String trailer) {
        super(id, registerNumber, "RefrigeratedTruck", model, trailer);
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
        return new RefrigeratedTruck();
    }
}
