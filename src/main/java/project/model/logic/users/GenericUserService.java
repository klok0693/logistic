package project.model.logic.users;

import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.model.data.users.GenericUserData;
import project.model.logic.GenericEntityService;
import project.model.logic.ServiceException;

/**
 * Created by klok on 27.2.18.
 */
@NotNullByDefault
@Transactional
public class GenericUserService<V extends Authentication>
        extends GenericEntityService<V, GenericUserData<V>> implements UserService<V> {

    @Override
    public V get(String userName) throws ServiceException {
        return null;
    }
}
