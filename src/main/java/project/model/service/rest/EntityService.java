package project.model.service.rest;

import org.springframework.data.repository.CrudRepository;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.service.ServiceException;

/**
 * Created by klok on 15.1.18.
 */
@NotNullByDefault
public interface EntityService<T extends Entity> {

    void save(T obj)     throws ServiceException;

    T get(int id)        throws ServiceException;

    void update(T obj)   throws ServiceException;

    void delete(T obj)   throws ServiceException;

    void delete(int id)  throws ServiceException;


    <R extends CrudRepository<T, Integer>> void setData(R data);
    <D extends CrudRepository<T, Integer>> D getData();
}
