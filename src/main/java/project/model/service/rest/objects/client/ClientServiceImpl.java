package project.model.service.rest.objects.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.model.data.DataException;
import project.model.data.objects.client.ClientData;
import project.model.service.ServiceException;
import project.model.service.rest.GenericEntityService;

import java.util.Collection;

import static org.springframework.transaction.annotation.Isolation.REPEATABLE_READ;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
@Transactional(isolation = REPEATABLE_READ, timeout = 60)

//@Accessors(chain = true)
@Service
@Getter @Setter
@NoArgsConstructor
public class ClientServiceImpl extends GenericEntityService<Client, ClientData> implements ClientService {

    @Autowired
    public ClientServiceImpl(ClientData data) {
        super(data);
    }

    @Override
    public Collection<Client> getAll(int company) throws ServiceException {
        try {
            return data.getAll(company);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }

    @Override
    public Client get(String userName) throws ServiceException {
        try {
            return data.get(userName);
        }
        catch (DataException e) {
            throw getException(e);
        }
    }
}
