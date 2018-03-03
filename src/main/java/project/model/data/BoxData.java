package project.model.data;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.BoxCargo;

import java.util.List;

/**
 * Created by klok on 2.3.18.
 */
@NotNullByDefault
@Transactional

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoxData {
    protected SessionFactory factory;


    public void save(BoxCargo obj) throws DataException {
        getCurrentSession().flush();
        getCurrentSession().save(obj);
    }


    public BoxCargo get(int id) throws DataException {
        return getCurrentSession().get(BoxCargo.class, id);
    }


    @Synchronized
    public void update(BoxCargo obj) throws DataException {
        getCurrentSession().update(obj);
    }


    @Synchronized
    public void delete(BoxCargo obj) throws DataException {
        getCurrentSession().delete(obj);
    }


    public List getAll() throws DataException {
        return getCurrentSession()
                .createCriteria(BoxCargo.class)
                .list();
    }


    protected Session getCurrentSession() {
        return factory.getCurrentSession();
    }
}
