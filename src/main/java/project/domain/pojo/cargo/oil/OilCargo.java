package project.domain.pojo.cargo.oil;

import project.NotNullByDefault;
import project.domain.pojo.cargo.AbstractCargo;
import project.domain.pojo.clients.Client;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * hibernate entity
 */
@NotNullByDefault
class OilCargo extends AbstractCargo implements Oil {

    public OilCargo() {}

    public OilCargo(
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
    public Oil newInstance() {
        return new OilCargo();
    }
}
