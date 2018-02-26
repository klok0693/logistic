package project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.User;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.truck.Truck;
import project.factory.Factory;
import project.model.data.UserDao;
import project.model.data.UserGenericDao;
import project.model.logic.EntityService;
import project.model.logic.ServiceException;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

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


    //(json) get Cargo
    @RequestMapping(value = "/cargo", method = GET, produces = "application/json")
    public @ResponseBody Collection<Cargo> getCargo() {

        Collection<Cargo> cargo;
        try {
            //get all cargo from bd
            cargo = Factory.getService(Cargo.class).getAll();
            return cargo.isEmpty()? null : cargo;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping(value = "/cargo", method = POST, produces = "application/json")
    public @ResponseBody boolean saveCargo(@RequestBody Cargo cargo) {

        try {
            EntityService<Cargo> service = Factory.getService(Cargo.class);
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserDao<Client> userDao = Factory.getUserData(Client.class);

            Client client = userDao.getEntityByUserName(userDetails.getUsername());


            System.out.println("\n");
            System.out.println(client);
            System.out.println("\n");

            cargo.setOwner(client);
            //client.addCargo(cargo);

            System.out.println("\n");
            System.out.println(cargo);
            //System.out.println(client.getCargoSet());
            System.out.println("\n");

            service.save(cargo);
            //Factory.getService(Client.class).update(client);
            return true;
        }
        catch (ServiceException e) {
            e.printStackTrace();
            return false;
        }
    }


    @RequestMapping(value = "/cargo", method = PUT, produces = "application/json")
    public @ResponseBody boolean updateCargo(@RequestBody Cargo cargo) {

        try {
            EntityService<Cargo> service = Factory.getService(Cargo.class);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            System.out.println("\n");
            System.out.println(user.getId());
            System.out.println("\n");

            UserDao<Client> userDao = new UserGenericDao<>();
            Client client = userDao.getEntityByUserId(user.getId());

            cargo.setOwner(client);
            client.addCargo(cargo);

            System.out.println("\n");
            System.out.println(cargo);
            System.out.println("\n");

            service.update(cargo);
            return true;

            //return Factory.getService(Cargo.class).getAll();
        }
        catch (ServiceException e) {
            e.printStackTrace();
            return false;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/grid")
    public ModelAndView getGrid() {
        //get users roles
        Collection<? extends GrantedAuthority> roles =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        //return home page according to users role
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
}
