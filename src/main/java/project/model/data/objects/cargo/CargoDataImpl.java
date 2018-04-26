package project.model.data.objects.cargo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.CatchException;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.model.data.DataException;
import project.model.data.GenericEntityData;

import java.util.Collection;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
@Transactional(propagation = REQUIRED, rollbackFor = DataException.class)

@Log4j
@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
public class CargoDataImpl extends GenericEntityData<Cargo> implements CargoData{


    @Override
    @CatchException(message = "Can't load cargo list")
    public Collection<Cargo> getAll(String clientName, int store) throws DataException {

        String query = "get"+entityClass.getSimpleName()+"ListByUserName";
        Query<Cargo> q = getCurrentSession()
                .createNamedQuery(query)
                .setString("username", clientName)
                .setInteger("store", store);

        return q.list();
    }
}
