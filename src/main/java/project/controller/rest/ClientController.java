package project.controller.rest;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.aspect.NotNullByDefault;
import project.controller.AbstractRestController;
import project.domain.entity.pojo.client.Client;
import project.factory.Factory;
import project.model.data.DataException;
import project.model.service.rest.objects.client.ClientService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by klok on 25.4.18.
 */
@NotNullByDefault

@Log4j
@NoArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController extends AbstractRestController<Client, ClientService> {

    public ClientController(ClientService service) {
        super(service);
    }

    @Override
    public boolean save(@RequestBody Client obj) {
        return false;
    }

    @RequestMapping(method = GET, value = "/single", produces = "application/json")
    public @ResponseBody Client loadClient() {

        try {
            return Factory.getUserData(Client.class).get(
                    SecurityContextHolder
                            .getContext()
                            .getAuthentication()
                            .getName()
            );
        }
        catch (DataException e) {
            return null;
        }
    }
}
