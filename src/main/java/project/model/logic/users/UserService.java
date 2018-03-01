package project.model.logic.users;

import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.model.logic.EntityService;
import project.model.logic.ServiceException;

/**
 * Created by klok on 27.2.18.
 */
@NotNullByDefault
public interface UserService<T extends Authentication> extends EntityService<T>{

    T get(String userName) throws ServiceException;
}
