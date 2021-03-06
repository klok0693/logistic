package project.model.data;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.CatchException;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Created by klok on 11.10.17.
 * Provides CRUD operation's + getAll() for Entity-classes;
 * Here I have been used Lombok, the annotation preprocessor;
 */
@NotNullByDefault
@Transactional(propagation = REQUIRED, rollbackFor = DataException.class)

@Log4j
@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericEntityData<T extends Entity> implements EntityData<T> {
    protected SessionFactory factory;
    protected Class<T> entityClass;

    @Override
    @CatchException(message = "Can't save entity")
    public void save(T obj) throws DataException {
        getCurrentSession().save(obj);
    }


    @Override
    @CatchException(message = "Can't load entity")
    public T get(int id) throws DataException {
        /*String s1 = "client1";
        getCurrentSession().createCriteria(entityClass).add(Restrictions.eq("user", s1));*/

        return getCurrentSession().get(entityClass, id);
    }


    @Override
    @Synchronized
    @CatchException(message = "Can't update entity")
    public void update(T obj) throws DataException {
        getCurrentSession().update(obj);
    }


    //delete object
    @Override
    @Synchronized
    @CatchException(message = "Can't delete entity")
    public void delete(T obj) throws DataException {
        getCurrentSession().delete(obj);
    }


    //delete by id
    @Override
    @Synchronized
    @CatchException(message = "Can't delete entity")
    public void delete(int id) throws DataException {
        String hql = "delete " + entityClass.getSimpleName() + " where id = :id";
        Query q = getCurrentSession().createQuery(hql).setParameter("id", id);
        q.executeUpdate();
    }


    protected Session getCurrentSession() {
        return factory.getCurrentSession();
    }

    /*@Override
    public GenericDao<T> setEntityClass(Class<T> aClass){
        this.entityClass=aClass;
        return this;
    }*/
}
