package project.model.data;

import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

/**
 * Created by klok on 27.10.17.
 * Provides CRUD operation's for entity-classes
 */
@NotNullByDefault
public interface EntityData<T extends Entity> {

    void save(T obj)     throws DataException;

    T get(int id)        throws DataException;

    void update(T obj)   throws DataException;

    void delete(T obj)   throws DataException;

    void delete(int id)  throws DataException;

    EntityData<T> setEntityClass(Class<T> aClass);
}
