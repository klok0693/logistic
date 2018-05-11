package project.model.data.objects.storehouse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.CatchException;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.storehouse.StoreHouse;
import project.model.data.DataException;
import project.model.data.GenericEntityData;

import java.util.Collection;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
@Transactional(propagation = REQUIRED, rollbackFor = DataException.class)

@Log4j
@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
public class StoreHouseDataImpl extends GenericEntityData<StoreHouse> {


    //@Override
    @CatchException(message = "Can't load storehouse list")
    public Collection<StoreHouse> getAll() throws DataException {
        return getCurrentSession()
                .createCriteria(StoreHouse.class)
                .list();
    }
}
