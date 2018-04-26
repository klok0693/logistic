package project.model.data.objects.client;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.model.data.DataException;
import project.model.data.users.UserData;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface ClientData extends UserData<Client> {

    Collection<Client> getAll(int company) throws DataException;
}
