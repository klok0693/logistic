package project.model.service.rest.objects.cargo;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.model.service.rest.EntityService;
import project.model.service.ServiceException;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface CargoService extends EntityService<Cargo> {

    Collection<Cargo> getAll(String username, int store)  throws ServiceException;
}
