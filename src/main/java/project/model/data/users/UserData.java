package project.model.data.users;

import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.model.data.DataException;
import project.model.data.EntityData;

/**
 * Created by klok on 19.2.18.
 */
@NotNullByDefault
public interface UserData<V extends Authentication> extends EntityData<V> {

    V get(String userName) throws DataException;
}
