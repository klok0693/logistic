package project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import project.NotNullByDefault;
import project.domain.entity.pojo.clients.Client;
import project.factory.Factory;

import java.util.Deque;
import java.util.LinkedList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by klok on 6.10.17.
 */
@Log4j
@Controller
@NotNullByDefault
public class LogisticServlet {

    static { Factory.setApplicationContext("root-context.xml"); }

    //welcome page
    @ResponseBody
    @RequestMapping(value = "/")
    public ModelAndView getIndex() {
        return new ModelAndView("Index");
    }


    //success authorization
    @RequestMapping(value = "/success", method = GET, produces = "application/json")
    public @ResponseBody boolean getSuccessAuth() {
        return true;
    }


    //authorization failure
    @RequestMapping(value = "/failure", method = GET, produces = "application/json")
    public @ResponseBody boolean getFailureAuth() {
        return false;
    }


    //(json) get Clients
    @RequestMapping(value = "/client", method = GET, produces = "application/json")
    public @ResponseBody Client getClients() {

        Deque<Client> clientDeque;
        try {
            clientDeque  = new LinkedList<>();
            clientDeque.addAll(getFactory().getData(Client.class).getAll());

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


    //get table with clients
    @ResponseBody
    @RequestMapping(value = "/grid")
    public ModelAndView getGrid() {
        return new ModelAndView("Catalog");
    }


    private Factory getFactory() throws Exception {
        try {
            return Factory.getFactory();
        }
        catch (Exception e) {
            log.error("Can't create beanFactory, throw exception", e);
            throw e;
        }
    }
}
