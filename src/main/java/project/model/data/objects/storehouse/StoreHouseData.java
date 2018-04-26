package project.model.data.objects.storehouse;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.storehouse.StoreHouse;
import project.model.data.DataException;
import project.model.data.EntityData;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface StoreHouseData extends EntityData<StoreHouse> {

    Collection<StoreHouse> getAll() throws DataException;
}
