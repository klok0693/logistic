package project.model.data;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.domain.entity.ejb.authentication.User;
import project.domain.entity.pojo.client.Client;

/**
 * Created by klok on 19.2.18.
 */
@NotNullByDefault
@Transactional

public class UserGenericDao<V extends Authentication> extends EntityGenericDao<V> implements UserDao<V> {

    @Override
    public V getEntityByUserId(int userId) {
        return (V) getCurrentSession().createSQLQuery("SELECT * FROM Clients WHERE user="+userId).uniqueResult();
    }

    @Override
    public V getEntityByUserName(String userName) {

        User user = (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username",userName)).uniqueResult();

        Query<Client> query = getCurrentSession().getNamedSQLQuery("getClientByUserId")
                .setInteger("userId", user.getId());

        Client client = query.uniqueResult();

        System.out.println("\n");
        //System.out.println(client.getUser().getAuthorities());
        System.out.println("\n");

        return (V) client;
    }
}
