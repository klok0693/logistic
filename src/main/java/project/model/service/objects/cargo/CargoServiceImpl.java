package project.model.service.objects.cargo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.model.data.DataException;
import project.model.data.objects.cargo.CargoData;
import project.model.service.GenericEntityService;
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
public class CargoServiceImpl extends GenericEntityService<Cargo, CargoData> implements CargoService {

    @Override
    public Collection<Cargo> getAll(String username, int store) throws ServiceException {

        try {
            return data.getAll(username, store);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }
}
