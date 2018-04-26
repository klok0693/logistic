package project.model.data.users;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.CatchException;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.model.data.DataException;
import project.model.data.GenericEntityData;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Created by klok on 19.2.18.
 */
@NotNullByDefault
@Transactional(propagation = REQUIRED, rollbackFor = DataException.class)

public class GenericUserData<V extends Authentication> extends GenericEntityData<V> implements UserData<V> {

    /*@Override
    public V get(int userId) {
        return (V) getCurrentSession().createSQLQuery("SELECT * FROM Clients WHERE user="+userId).uniqueResult();
    }*/

    @Override
    @CatchException(message = "can't load entity")
    public V get(String userName) throws DataException {

        String queryName = "get"+entityClass.getSimpleName()+"ByUserName";

        Query<V> query = getCurrentSession()
                            .createNamedQuery(queryName)
                            .setString("username", userName);

        return query.uniqueResult();
    }
}
