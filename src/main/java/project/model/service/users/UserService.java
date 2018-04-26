package project.model.service.users;

import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.model.service.EntityService;
import project.model.service.ServiceException;

/**
 * Created by klok on 27.2.18.
 */
@NotNullByDefault
public interface UserService<T extends Authentication> extends EntityService<T>{

    T get(String userName) throws ServiceException;
}
