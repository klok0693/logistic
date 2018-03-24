package project.domain.entity.pojo.cargo.oil;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.AbstractCargo;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.storehouse.StoreHouse;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class OilCargo extends AbstractCargo implements Oil {

    public OilCargo() {
        super("OilCargo");
    }

    public OilCargo(
                    int id,
                    String type,
                    Date productionDate,
                    Date shelfLife,
                    Client owner,
                    StoreHouse store,
                    int size,
                    String format)
    {
        super(id, size, type, format, "OilCargo", productionDate, shelfLife, owner, store);
    }

    @Override
    public Oil newInstance() {
        return new OilCargo();
    }
}
