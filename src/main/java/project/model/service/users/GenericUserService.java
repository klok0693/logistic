package project.model.service.users;

import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.model.data.DataException;
import project.model.data.users.GenericUserData;
import project.model.service.GenericEntityService;
import project.model.service.ServiceException;

/**
 * Created by klok on 27.2.18.
 */
@NotNullByDefault
@Transactional
public class GenericUserService<V extends Authentication, D extends GenericUserData<V>>
                             extends GenericEntityService<V, D> implements UserService<V> {

    @Override
    public V get(String userName) throws ServiceException {
        try {
            return data.get(userName);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }
}
