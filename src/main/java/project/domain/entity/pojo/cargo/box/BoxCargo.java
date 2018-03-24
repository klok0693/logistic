package project.domain.entity.pojo.cargo.box;

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
public class BoxCargo extends AbstractCargo implements Box {

    public BoxCargo() {
        super("BoxCargo");
    }

    public BoxCargo(
                    int id,
                    String type,
                    Date productionDate,
                    Date shelfLife,
                    Client owner,
                    StoreHouse store,
                    int size,
                    String format)
    {
        super(id, size, type, format, "BoxCargo", productionDate, shelfLife, owner, store);
    }

    @Override
    public Box newInstance() {
        return new BoxCargo();
    }
}
