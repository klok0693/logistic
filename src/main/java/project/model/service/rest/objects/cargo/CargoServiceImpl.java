package project.model.service.rest.objects.cargo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.model.data.DataException;
import project.model.data.objects.cargo.CargoData;
import project.model.service.ServiceException;
import project.model.service.rest.GenericEntityService;

import java.util.Collection;

import static org.springframework.transaction.annotation.Isolation.REPEATABLE_READ;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
@Transactional(isolation = REPEATABLE_READ, timeout = 60)

//@Accessors(chain = true)
@Service
@Getter @Setter
@NoArgsConstructor
public class CargoServiceImpl extends GenericEntityService<Cargo, CargoData> implements CargoService {

    @Autowired
    public CargoServiceImpl(CargoData data) {
        super(data);
    }

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
