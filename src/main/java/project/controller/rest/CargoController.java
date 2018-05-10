package project.controller.rest;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.aspect.NotNullByDefault;
import project.controller.AbstractRestController;
import project.domain.entity.pojo.cargo.Cargo;
import project.model.service.ServiceException;
import project.model.service.rest.objects.cargo.CargoService;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by klok on 12.3.18.
 */
@NotNullByDefault

@Log4j
@NoArgsConstructor
@RestController
@RequestMapping("/cargo/*")
public class CargoController extends AbstractRestController<Cargo, CargoService> {

    public CargoController(CargoService service) {
        super(service);
    }

    @RequestMapping(value = "/all", method = GET, produces = "application/json")
    public @ResponseBody Collection<Cargo> getAll(@PathParam("store") @Valid Integer store) {

        //
        if (store == null) store = 0;

        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return service.getAll(username, store);
        }
        catch (ServiceException e) {
            return null;
        }
    }
}
