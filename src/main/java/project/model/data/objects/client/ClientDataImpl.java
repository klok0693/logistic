package project.model.data.objects.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.CatchException;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.model.data.DataException;
import project.model.data.users.GenericUserData;

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
public class ClientDataImpl extends GenericUserData<Client> {


    //@Override
    @CatchException(message = "Can't load clients list")
    public Collection<Client> getAll(int company) throws DataException {
        return getCurrentSession()
                .createCriteria(Client.class)
                .add(Restrictions.eq("organization", company))
                .list();
    }
}
