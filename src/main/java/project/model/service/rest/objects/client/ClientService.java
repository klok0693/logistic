package project.model.service.rest.objects.client;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.model.service.ServiceException;
import project.model.service.rest.users.UserService;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface ClientService extends UserService<Client> {

    Collection<Client> getAll(int company) throws ServiceException;
}
