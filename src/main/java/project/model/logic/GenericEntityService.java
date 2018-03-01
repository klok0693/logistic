package project.model.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.DataException;
import project.model.data.EntityData;

import java.util.Collection;

/**
 * Created by klok on 11.10.17.
 */
@NotNullByDefault
@Transactional

//@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericEntityService<T extends Entity, D extends EntityData<T>> implements EntityService<T> {
    //private EntityData<T> data;
    protected D data;
    //private Class<T> type;


    @Override
    public void save(T obj) throws ServiceException {
       try{
            data.save(obj);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }

    @Override
    public T get(int id) throws ServiceException {
        try {
            return data.get(id);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }

    @Override
    public void update(T obj) throws ServiceException {
        try {
            data.update(obj);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }

    @Override
    public void delete(T obj) throws ServiceException {
        try {
            data.delete(obj);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }

    @Override
    public Collection<T> getAll() throws ServiceException{
        try {
            return data.getAll();
        }
        catch (DataException e) {
            throw getException(e);
        }
    }

    @Override
    public <E extends EntityData<T>> void setData(E data) {
        this.data = (D) data;
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
