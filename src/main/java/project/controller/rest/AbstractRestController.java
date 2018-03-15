package project.controller.rest;

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
import project.model.logic.EntityService;
import project.model.logic.ServiceException;

import java.util.Collection;

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
public abstract class AbstractRestController<T extends Entity> {
    protected EntityService<T> service;
    protected Class<T> aClass;

    protected AbstractRestController(EntityService<T> service) {
        this.service = service;
    }


    /*@RequestMapping(method = POST, produces = "application/json")
    public @ResponseBody boolean save(@RequestBody T obj) {

        try {
            service.save(obj);
            return true;
        }
        catch (ServiceException e) {
            return false;
        }
    }*/


    @RequestMapping(method = POST, produces = "application/json")
    public abstract @ResponseBody boolean save(@RequestBody T obj);


    @RequestMapping(method = GET, produces = "application/json")
    public @ResponseBody Collection<T> getAll() {
        try {
            return service.getAll();
        }
        catch (ServiceException e) {
            return null;
        }
    }


    @RequestMapping(value = "/*", method = PUT, produces = "application/json")
    public @ResponseBody boolean update(@RequestBody T obj) {
        try {
            service.update(obj);
            return true;
        }
        catch (ServiceException e) {
            return false;
        }
    }


    @RequestMapping(value = "/*", method = DELETE, produces = "application/json")
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
