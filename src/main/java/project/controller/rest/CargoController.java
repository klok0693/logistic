package project.controller.rest;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.client.Client;
import project.factory.Factory;
import project.model.data.DataException;
import project.model.data.users.UserData;
import project.model.logic.EntityService;
import project.model.logic.ServiceException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by klok on 12.3.18.
 */
@NotNullByDefault

@Log4j
@NoArgsConstructor
@RestController
@RequestMapping("/cargo")
public class CargoController extends AbstractRestController<Cargo> {

    public CargoController(EntityService<Cargo> service) {
        super(service);
    }

    @Override
    @RequestMapping(method = POST, produces = "application/json")
    public @ResponseBody boolean save(@RequestBody Cargo cargo) {

        Client client;
        Authentication authentication;

        UserData<Client> clientService;
        try {
            //
            clientService   = Factory.getUserData(Client.class);

            //
            authentication  = SecurityContextHolder.getContext().getAuthentication();
            client          = clientService.get(authentication.getName());

            cargo.setOwner(client);
            service.save(cargo);

            return true;
        }
        catch (ServiceException | DataException e) {
            return false;
        }
    }
}
