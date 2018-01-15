package project.model.data;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.NotNullByDefault;
import project.domain.entity.Entity;

import java.util.List;

/**
 * Created by klok on 11.10.17.
 * Provides CRUD operation's + getAll() for Entity-classes;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@Log4j
@Transactional(propagation = Propagation.SUPPORTS)
@NotNullByDefault
@AllArgsConstructor
class EntityGenericDao<T extends Entity> implements GenericDao<T> {
    private SessionFactory factory;
    private Class<T> type;


    public void save(T obj) throws DaoException{
        try {
            getCurrentSession().save(obj);
        }
        catch (HibernateException e) {
            log.error("Can't save "+getErrorMessage(obj), e);
            throw getException(e);
        }
    }

    public T get(int id) throws DaoException {
        try {
            return getCurrentSession().get(type, id);
        }
        catch (HibernateException e) {
            log.error("Can't load object: id="+id+" "+getErrorMessage(type), e);
            throw getException(e);
        }
    }

    public void update(T obj) throws DaoException {
        try {
            getCurrentSession().update(obj);
        }
        catch (HibernateException e) {
            log.error("Can't update "+getErrorMessage(obj), e);
            throw getException(e);
        }
    }

    public void delete(T obj) throws DaoException {
        try {
            getCurrentSession().delete(obj);
        }
        catch (HibernateException e) {
            log.error("Can't delete "+getErrorMessage(obj), e);
            throw getException(e);
        }
    }

    public List<? extends T> getAll() throws DaoException {
        try {
            return getCurrentSession()
                    .createCriteria(type)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        }
        catch (HibernateException e) {
            log.error("Can't load list "+getErrorMessage(type), e);
            throw getException(e);
        }
    }


    private Session getCurrentSession() {
        return factory.getCurrentSession();
    }

    private DaoException getException(Exception e) {
        return new DaoException(e);
    }

    private String getErrorMessage(Object obj) {
        return obj.getClass()+", throws DaoException";
    }
}
