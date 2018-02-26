package project.model.data;

import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;

/**
 * Created by klok on 19.2.18.
 */
@NotNullByDefault
public interface UserDao<V extends Authentication> extends EntityDao<V> {

    V getEntityByUserId(int userId);

    V getEntityByUserName(String userName);
}
