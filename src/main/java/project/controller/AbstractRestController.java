package project.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.service.EntityService;
import project.model.service.ServiceException;

import javax.ws.rs.PathParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by klok on 12.3.18.
 * Parent class for all REST CRUD-controllers
 */
@NotNullByDefault

@Log4j
@Getter @Setter
@NoArgsConstructor
@RestController
public abstract class AbstractRestController<T extends Entity, S extends EntityService<T>> {
    protected S service;

    protected AbstractRestController(S service) {
        this.service = service;
    }


    @RequestMapping(method = GET, produces = "application/json")
    public @ResponseBody T load(@PathParam("id") Integer id) {

        if (id == null) return null;

        try {
            return service.get(id);
        }
        catch (ServiceException e) {
            return null;
        }
    }


    @RequestMapping(method = POST, produces = "application/json")
    public @ResponseBody boolean save(@RequestBody T obj) {

        try {
            service.save(obj);
            return true;
        }
        catch (ServiceException e) {
            return false;
        }
    }


    @RequestMapping(method = PUT, produces = "application/json")//application/x-www-form-urlencoded;charset=UTF-8
    public @ResponseBody boolean update(@RequestBody T obj) {
        try {
            service.update(obj);
            return true;
        }
        catch (ServiceException e) {
            return false;
        }
    }


    @RequestMapping(method = DELETE, produces = "application/json")
    public @ResponseBody boolean delete(@RequestBody T obj) {
        try {
            service.delete(obj.getId());
            return true;
        }
        catch (ServiceException e) {
            return false;
        }
    }
}
