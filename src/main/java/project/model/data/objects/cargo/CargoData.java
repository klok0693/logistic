package project.model.data.objects.cargo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.model.data.DataException;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface CargoData extends CrudRepository<Cargo, Integer> {

    @Query(value = "SELECT * FROM cargo_list WHERE clientName = :clientName AND store = :store", nativeQuery = true)
    Collection<Cargo> getAll(@Param("clientName") String clientName,@Param("store") int store) throws DataException;
}
