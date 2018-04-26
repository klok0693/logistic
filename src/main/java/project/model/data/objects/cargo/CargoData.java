package project.model.data.objects.cargo;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.model.data.DataException;
import project.model.data.EntityData;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface CargoData extends EntityData<Cargo> {

    Collection<Cargo> getAll(String clientName, int store) throws DataException;
}
