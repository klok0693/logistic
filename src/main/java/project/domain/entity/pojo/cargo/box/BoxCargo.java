package project.domain.entity.pojo.cargo.box;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.AbstractCargo;
import project.domain.entity.pojo.client.Client;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * hibernate entity
 */
@NotNullByDefault
public class BoxCargo extends AbstractCargo implements Box {

    public BoxCargo() {}

    public BoxCargo(
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
    public Box newInstance() {
        return new BoxCargo();
    }
}
