package project.domain.pojo.cargo.products;

import project.NotNullByDefault;
import project.domain.pojo.cargo.AbstractCargo;
import project.domain.pojo.clients.Client;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * hibernate entity
 */
@NotNullByDefault
class ProductCargo extends AbstractCargo implements Product {

    public ProductCargo() {}

    public ProductCargo(
                        int id,
                        String name,
                        Date productionDate,
                        Date shelfLife,
                        Client owner,
                        int size,
                        String format)
    {
        super(id, name, productionDate, shelfLife, owner, size, format);
    }

    @Override
    public Product newInstance() {
        return new ProductCargo();
    }
}
