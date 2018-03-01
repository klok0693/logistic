package project.model.data.users;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.CatchException;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.domain.entity.ejb.authentication.User;
import project.model.data.DataException;
import project.model.data.GenericEntityData;

/**
 * Created by klok on 19.2.18.
 */
@NotNullByDefault
@Transactional

public class GenericUserData<V extends Authentication> extends GenericEntityData<V> implements UserData<V> {

    /*@Override
    public V get(int userId) {
        return (V) getCurrentSession().createSQLQuery("SELECT * FROM Clients WHERE user="+userId).uniqueResult();
    }*/

    @Override
    @CatchException(message = "can't load entity")
    public V get(String userName) throws DataException {

        User user = (User) getCurrentSession()
                               .createCriteria(User.class)
                               .add(Restrictions.eq("username", userName))
                               .uniqueResult();

        String queryName = "get"+entityClass.getSimpleName()+"ByUserId";
        Query<V> query = getCurrentSession()
                             .getNamedSQLQuery(queryName)
                             .setInteger("userId", user.getId());

        return query.uniqueResult();
    }
}
