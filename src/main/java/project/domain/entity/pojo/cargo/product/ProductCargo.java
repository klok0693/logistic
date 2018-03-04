package project.domain.entity.pojo.cargo.product;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.AbstractCargo;
import project.domain.entity.pojo.client.Client;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class ProductCargo extends AbstractCargo implements Product {

    public ProductCargo() {
        super("ProductCargo");
    }

    public ProductCargo(
                        int id,
                        String type,
                        Date productionDate,
                        Date shelfLife,
                        Client owner,
                        int size,
                        String format)
    {
        super(id, size, type, format, "ProductCargo", productionDate, shelfLife, owner);
    }

    @Override
    public Product newInstance() {
        return new ProductCargo();
    }
}
