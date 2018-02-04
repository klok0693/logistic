package project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.factory.Factory;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by klok on 6.10.17.
 */
@NotNullByDefault

@Log4j
@Controller
public class LogisticServlet {

    static { Factory.getFactory().setApplicationContext("root-context.xml"); }

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
    public @ResponseBody Collection<Client> getClients() {

        Deque<Client> clientDeque;
        try {
            //get all Client's from bd
            clientDeque  = new LinkedList<>(Factory.getData(Client.class).getAll());
            return clientDeque.isEmpty()? null : clientDeque;
        }
        catch (Exception e) {
            System.out.println(e.getClass());
            return null;
        }
    }


    //get table with clients
    @ResponseBody
    @RequestMapping(value = "/grid")
    public ModelAndView getGrid() {
        return new ModelAndView("Catalog");
    }
}
