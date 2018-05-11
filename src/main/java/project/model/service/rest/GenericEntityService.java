package project.model.service.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.service.ServiceException;

import static org.springframework.transaction.annotation.Isolation.REPEATABLE_READ;

/**
 * Created by klok on 11.10.17.
 */
@NotNullByDefault
@Transactional(isolation = REPEATABLE_READ, timeout = 60)

//@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericEntityService<T extends Entity, D extends CrudRepository<T, Integer>> implements EntityService<T> {
    //private EntityData<T> data;
    @Autowired
    protected D data;
    //private Class<T> type;


    @Override
    public void save(T obj) throws ServiceException {
       try{
            data.save(obj);
        }
        catch (Exception e) {
            throw getException(e);
        }
    }

    @Override
    public T get(int id) throws ServiceException {
        try {
            return data.findById(id).get();
        }
        catch (Exception e) {
            throw getException(e);
        }
    }

    @Override
    public void update(T obj) throws ServiceException {
        try {
            data.save(obj) ;
        }
        catch (Exception e) {
            throw getException(e);
        }
    }

    @Override
    public void delete(T obj) throws ServiceException {
        try {
            data.delete(obj);
        }
        catch (Exception e) {
            throw getException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            data.deleteById(id);
        }
        catch (Exception e) {
            throw getException(e);
        }
    }

    @Override
    public <R extends CrudRepository<T, Integer>> void setData(R data) {
        this.data = (D) data;
    }

    /*@Override
    public Service<T> setEntityClass(Class<T> aClass) {
        this.type = aClass;
        return this;
    }*/

    protected ServiceException getException(Exception e) {
        return new ServiceException(e);
    }
}
