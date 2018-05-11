package project.model.data.objects.storehouse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.storehouse.StoreHouse;
import project.model.data.DataException;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface StoreHouseData extends CrudRepository<StoreHouse, Integer> {

    @Query(value = "SELECT * FROM store_houses", nativeQuery = true)
    Collection<StoreHouse> getAll() throws DataException;
}
