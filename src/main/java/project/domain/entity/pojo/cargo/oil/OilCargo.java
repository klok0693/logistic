package project.domain.entity.pojo.cargo.oil;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.AbstractCargo;
import project.domain.entity.pojo.client.Client;

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
                    int size,
                    String format)
    {
        super(id, size, type, format, "OilCargo", productionDate, shelfLife, owner);
    }

    @Override
    public Oil newInstance() {
        return new OilCargo();
    }
}
