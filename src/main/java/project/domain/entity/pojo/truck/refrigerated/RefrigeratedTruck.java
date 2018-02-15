package project.domain.entity.pojo.truck.refrigerated;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.product.Product;
import project.domain.entity.pojo.organization.Organization;
import project.domain.entity.pojo.truck.AbstractTruck;

import java.util.List;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class RefrigeratedTruck extends AbstractTruck<Product> implements Refrigerated {

    public RefrigeratedTruck() {
        super("RefrigeratedTruck");
    }

    public RefrigeratedTruck(int id, int registerNumber, String model, String trailer, Organization organization) {
        super(id, registerNumber, "RefrigeratedTruck", model, trailer, organization);
    }

    @Override
    public void loadCargo(List<Product> cargo) {
        this.cargo = cargo;
    }

    @Override
    public List<Product> takeCargo() {
        return cargo;
    }

    @Override
    public Refrigerated newInstance() {
        return new RefrigeratedTruck();
    }
}
