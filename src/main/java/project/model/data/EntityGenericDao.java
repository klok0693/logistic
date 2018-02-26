package project.model.data;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.CatchException;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

import java.util.List;

/**
 * Created by klok on 11.10.17.
 * Provides CRUD operation's + getAll() for Entity-classes;
 * Here I have been used Lombok, the annotation preprocessor;
 */
@NotNullByDefault
@Transactional(propagation = Propagation.SUPPORTS)

@Log4j
@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityGenericDao<T extends Entity> implements EntityDao<T> {
    private SessionFactory factory;
    private Class<T> entityClass;



    @Override
    @CatchException(message = "Can't save entity")
    public void save(T obj) throws DaoException{
        getCurrentSession().save(obj);
    }


    @Override
    @CatchException(message = "Can't load entity")
    public T get(int id) throws DaoException {
        return getCurrentSession().get(entityClass, id);
    }


    @Override
    @Synchronized
    @CatchException(message = "Can't update entity")
    public void update(T obj) throws DaoException {
        getCurrentSession().update(obj);
    }


    @Override
    @Synchronized
    @CatchException(message = "Can't delete entity")
    public void delete(T obj) throws DaoException {
        getCurrentSession().delete(obj);
    }


    @Override
    @CatchException(message = "Can't load entity list")
    public List<T> getAll() throws DaoException {
        return getCurrentSession()
                .createCriteria(entityClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
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
