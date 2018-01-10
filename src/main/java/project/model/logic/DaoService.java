package project.model.logic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import project.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.GenericDao;

/**
 * Created by klok on 11.10.17.
 */
@NotNullByDefault
@Transactional
@Getter @Setter
public class DaoService<T extends Entity> {
    private GenericDao<T> data;

    public DaoService() {}

    public DaoService(GenericDao<T> data) {
        this.data = data;
    }

    /*
    public void save(T obj) {
        data.save(obj);
    }

    public T get(int id) {
        return data.get(id);
    }

    public void update(T obj) {
        data.update(obj);
    }

    public void delete(T obj) {
        data.delete(obj);
    }
    */
}
