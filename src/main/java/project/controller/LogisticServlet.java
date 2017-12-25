package project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
@Controller
@NotNullByDefault
public class LogisticServlet {

    @ResponseBody
    @RequestMapping(value = "/")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

    //@Secured(value = {"ROLE_USER"})
    @RequestMapping(value = "/getTrucks", method = RequestMethod.GET)
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

    //@Secured(value = {"ROLE_ANONYMOUS"})
    @RequestMapping(value = "/client", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Client getClients() {
        try {
            Factory factory = getFactory();
            Deque<Client> clientDeque = new LinkedList<>();
            clientDeque.addAll(factory.getClientData().getAll());

            if(!clientDeque.isEmpty()) {
                Client client = clientDeque.getFirst();
                //client.setOrganization(null);
                return client;
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }

    //@Secured(value = {"ROLE_ANONYMOUS"})
    @RequestMapping(value = "/login")
    public String getCatalogIndex(){
        return "CatalogIndex";
    }

    private Factory getFactory() throws Exception {
        try {
            return Factory.getFactory("root-context.xml");
        }
        catch (Exception e) {
            log.error("Can't create beanFactory, throw exception", e);
            throw e;
        }
    }

    private ModelAndView getErrorView() {
        return new ModelAndView("error");
    }
}
