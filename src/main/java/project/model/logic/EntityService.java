package project.model.logic;

import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.EntityDao;

import java.util.Collection;

/**
 * Created by klok on 15.1.18.
 */
@NotNullByDefault
public interface EntityService<T extends Entity> {

    void save(T obj)                  throws ServiceException;

    T get(int id)                     throws ServiceException;

    void update(T obj)                throws ServiceException;

    void delete(T obj)                throws ServiceException;

    Collection<T> getAll()  throws ServiceException;

    //Service<T> setEntityClass(Class<T> aClass);
    EntityService<T> setData(EntityDao<T> data);
}
