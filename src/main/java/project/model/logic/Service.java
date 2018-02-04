package project.model.logic;

import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.GenericDao;

import java.util.Collection;

/**
 * Created by klok on 15.1.18.
 */
@NotNullByDefault
public interface Service<T extends Entity> {

    void save(T obj)                  throws ServiceException;

    T get(int id)                     throws ServiceException;

    void update(T obj)                throws ServiceException;

    void delete(T obj)                throws ServiceException;

    Collection<? extends T> getAll()  throws ServiceException;

    Service<T> setEntityClass(Class<T> aClass);
    void setData(GenericDao<T> data);
}
