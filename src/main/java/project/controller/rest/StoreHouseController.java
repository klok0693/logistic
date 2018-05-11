package project.controller.rest;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.aspect.NotNullByDefault;
import project.controller.AbstractRestController;
import project.domain.entity.pojo.storehouse.StoreHouse;
import project.model.service.ServiceException;
import project.model.service.rest.objects.storehouse.StoreHouseService;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by klok on 25.4.18.
 */
@NotNullByDefault

@Log4j
@NoArgsConstructor
@RestController
@RequestMapping("/storehouse")
public class StoreHouseController extends AbstractRestController<StoreHouse, StoreHouseService> {

    @Autowired
    public StoreHouseController(StoreHouseService service) {
        super(service);
    }

    @Override
    public boolean save(@RequestBody StoreHouse obj) {
        return false;
    }

    @RequestMapping(value = "/all", method = GET, produces = "application/json")
    public @ResponseBody Collection<StoreHouse> getAll() {

        try {
            return service.getAll();
        }
        catch (ServiceException e) {
            return null;
        }
    }
}
