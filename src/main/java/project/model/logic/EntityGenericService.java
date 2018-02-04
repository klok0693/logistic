package project.model.logic;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.DaoException;
import project.model.data.EntityDao;

import java.util.Collection;

/**
 * Created by klok on 11.10.17.
 */
@NotNullByDefault
@Transactional

@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityGenericService<T extends Entity> implements EntityService<T> {
    private EntityDao<T> data;
    //private Class<T> type;


    @Override
    public void save(T obj) throws ServiceException {
       try{
            data.save(obj);
        }
        catch (DaoException e) {
            throw getException(e);
        }
    }

    @Override
    public T get(int id) throws ServiceException {
        try {
            return data.get(id);
        }
        catch (DaoException e) {
            throw getException(e);
        }
    }

    @Override
    public void update(T obj) throws ServiceException {
        try {
            data.update(obj);
        }
        catch (DaoException e) {
            throw getException(e);
        }
    }

    @Override
    public void delete(T obj) throws ServiceException {
        try {
            data.delete(obj);
        }
        catch (DaoException e) {
            throw getException(e);
        }
    }

    @Override
    public Collection<T> getAll() throws ServiceException{
        try {
            return data.getAll();
        }
        catch (DaoException e) {
            throw getException(e);
        }
    }

    /*@Override
    public Service<T> setEntityClass(Class<T> aClass) {
        this.type = aClass;
        return this;
    }*/

    private ServiceException getException(Exception e) {
        return new ServiceException(e);
    }
}
