package project.model.service.rest.objects.client;

import org.springframework.stereotype.Service;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.model.service.ServiceException;
import project.model.service.rest.EntityService;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault

@Service
public interface ClientService extends EntityService<Client> {

    Collection<Client> getAll(int company) throws ServiceException;

    Client get(String userName) throws ServiceException;
}
