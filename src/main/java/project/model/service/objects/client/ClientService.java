package project.model.service.objects.client;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.model.service.ServiceException;
import project.model.service.users.UserService;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface ClientService extends UserService<Client> {

    Collection<Client> getAll(int company) throws ServiceException;
}
