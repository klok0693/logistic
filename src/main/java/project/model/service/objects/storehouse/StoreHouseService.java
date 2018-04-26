package project.model.service.objects.storehouse;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.storehouse.StoreHouse;
import project.model.service.EntityService;
import project.model.service.ServiceException;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface StoreHouseService extends EntityService<StoreHouse> {

    Collection<StoreHouse> getAll() throws ServiceException;
}
