package project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import project.NotNullByDefault;
import project.domain.pojo.clients.Client;
import project.factory.Factory;
import project.model.data.DaoException;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by klok on 6.10.17.
 */
@Log4j
@RestController
@NotNullByDefault
public class LogisticServlet {

    private Factory getFactory() throws Exception {
        try {
            return Factory.getFactory("root-context.xml");
        }
        catch (Exception e) {
            log.error("Can't create beanFactory, throw exception", e);
            throw e;
        }
    }

    @Secured(value = {"ROLE_USER"})
    @RequestMapping(value = "/getTrucks",method = RequestMethod.GET)
    public ModelAndView getTrucks() {

        try {
            Factory factory = getFactory();
            Map<String, String> model = new HashMap<>();
            model.put("trucks", factory.getTruckData().getAll().toString());

            return new ModelAndView("trucks", model);
        }
        catch (DaoException e) {
            return getErrorView();
        }
        catch (Exception e) {
            return getErrorView();
        }
    }

    @Secured(value = {"ROLE_ANONYMOUS"})
    @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = "application/json")
    public Deque<Client> getClients() {
        try {
            Factory factory = getFactory();
            Deque<Client> clientDeque = new LinkedList<>();
            clientDeque.addAll(factory.getClientData().getAll());

            return clientDeque;
        }
        catch (Exception e) {
            return null;
        }
    }

    private ModelAndView getErrorView() {
        return new ModelAndView("error");
    }
}
