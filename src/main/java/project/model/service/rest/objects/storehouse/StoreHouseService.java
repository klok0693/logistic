package project.model.service.rest.objects.storehouse;

import org.springframework.stereotype.Service;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.storehouse.StoreHouse;
import project.model.service.rest.EntityService;
import project.model.service.ServiceException;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault

@Service
public interface StoreHouseService extends EntityService<StoreHouse> {

    Collection<StoreHouse> getAll() throws ServiceException;
}
