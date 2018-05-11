package project.model.data.objects.client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.model.data.DataException;

import java.util.Collection;

/**
 * Created by klok on 26.4.18.
 */
@NotNullByDefault
public interface ClientData extends CrudRepository<Client, Integer> {

    @Query(value = "SELECT * FROM clients WHERE company = :company", nativeQuery = true)
    Collection<Client> getAll(@Param("company") int company) throws DataException;

    @Query(value = "SELECT DISTINCT * FROM Clients c INNER JOIN Users u WHERE c.user=u.user_id AND u.username = :userName", nativeQuery = true)
    Client get(@Param("userName") String userName) throws DataException;
}
