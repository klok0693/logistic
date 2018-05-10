package project.model.service.rest.objects.storehouse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.storehouse.StoreHouse;
import project.model.data.DataException;
import project.model.data.objects.storehouse.StoreHouseDataImpl;
import project.model.service.rest.GenericEntityService;
import project.model.service.ServiceException;

import java.util.Collection;

import static org.springframework.transaction.annotation.Isolation.REPEATABLE_READ;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
@Transactional(isolation = REPEATABLE_READ, timeout = 60)

//@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
public class StoreHouseServiceImpl extends GenericEntityService<StoreHouse, StoreHouseDataImpl>
                                     implements StoreHouseService {


    @Override
    public Collection<StoreHouse> getAll() throws ServiceException {

        try {
            return data.getAll();
        }
        catch (DataException e) {
            throw getException(e);
        }
    }
}
