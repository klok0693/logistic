package project.model.data;

import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;

import java.util.List;

/**
 * Created by klok on 27.10.17.
 * Provides CRUD operation's + getAll() for entity-classes
 */
@NotNullByDefault
public interface EntityDao<T extends Entity> {

    void save(T obj)   throws DaoException;

    T get(int id)      throws DaoException;

    void update(T obj) throws DaoException;

    void delete(T obj) throws DaoException;

    List<T> getAll()   throws DaoException;

    EntityDao<T> setEntityClass(Class<T> aClass);
}