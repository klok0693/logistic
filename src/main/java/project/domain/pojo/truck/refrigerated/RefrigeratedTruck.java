package project.domain.pojo.truck.refrigerated;

import project.NotNullByDefault;
import project.domain.pojo.cargo.products.Product;
import project.domain.pojo.organizations.Organization;
import project.domain.pojo.truck.AbstractTruck;

import java.util.List;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
class RefrigeratedTruck extends AbstractTruck<Product> implements Refrigerated {

    public RefrigeratedTruck() {}

    public RefrigeratedTruck(int id, String model, Organization organization, String trailer, int registerNumber) {
        super(id, model, organization, trailer, registerNumber);
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
