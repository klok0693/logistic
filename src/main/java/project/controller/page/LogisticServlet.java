package project.controller.page;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.truck.Truck;
import project.factory.Factory;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by klok on 6.10.17.
 */
@NotNullByDefault

@Log4j
@Controller
//@RequestMapping("/")
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


    @ResponseBody
    @RequestMapping(value = "/grid")
    public ModelAndView getGrid() {
        //get user's roles
        Collection<? extends GrantedAuthority> roles =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        //return home page according to user's role
        String roleName;
        for (GrantedAuthority role : roles) {

            roleName = role.getAuthority().trim();
            System.out.println(roleName);

            if (roleName.contains("ROLE_CLIENT"))
                return new ModelAndView("ClientCatalog");

            if(roleName.contains("ROLE_MANAGER"))
                return new ModelAndView("ManagerCatalog");

            if(roleName.contains("ROLE_OWNER"))
                return new ModelAndView("OwnerCatalog");
        }
        return new ModelAndView("Index");
    }


    //(json) get Clients
    @RequestMapping(value = "/clients", method = GET, produces = "application/json")
    public @ResponseBody Collection<Client> getClients() {

        Collection<Client> clients;
        try {
            //get all Client's from bd
            clients = Factory.getService(Client.class).getAll();
            return clients.isEmpty()? null : clients;
        }
        catch (Exception e) {
            //System.out.println(e.getClass());
            e.printStackTrace();
            return null;
        }
    }


    //(json) get Trucks
    @RequestMapping(value = "/trucks", method = GET, produces = "application/json")
    public @ResponseBody Collection<Truck> getTrucks() {

        Collection<Truck> trucks;
        try {
            //get all trucks from bd
            trucks = Factory.getService(Truck.class).getAll();
            return trucks.isEmpty()? null : trucks;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
