package project.model.logic;

import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.EntityData;

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

    Collection<T> getAll()            throws ServiceException;

    <D extends EntityData<T>> void setData(D data);
}
