package project.domain.entity.pojo.truck.trucks;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.product.Product;
import project.domain.entity.pojo.organization.Organization;
import project.domain.entity.pojo.truck.AbstractTruck;
import project.domain.entity.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class RefrigeratedTruck extends AbstractTruck<Product> {

    public RefrigeratedTruck() {
        super("RefrigeratedTruck");
    }

    public RefrigeratedTruck(int id, int registerNumber, String model, String trailer, Organization organization) {
        super(id, registerNumber, "RefrigeratedTruck", model, trailer, organization);
    }

    @Override
    public Truck<Product> newInstance() {
        return new RefrigeratedTruck();
    }
}
