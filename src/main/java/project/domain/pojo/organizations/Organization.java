package project.domain.pojo.organizations;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import project.NotNullByDefault;
import project.domain.Instance;
import project.domain.pojo.Entity;
import project.domain.pojo.clients.Client;
import project.domain.pojo.employees.Employee;
import project.domain.pojo.truck.Truck;

import java.util.Set;

/**
 * Created by klok on 17.10.17.
 * Hibernate mapped-superclass;
 */
@NotNullByDefault
public interface Organization extends Entity, Instance<Organization> {

    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    String getOwner();
    void setOwner(String owner);

    @JsonManagedReference
    Set<Truck> getTrucks();
    void setTrucks(Set<Truck> trucks);

    @JsonBackReference
    Set<Client> getClients();
    void setClients(Set<Client> clients);

    @JsonManagedReference
    Set<Employee> getEmployees();
    void setEmployees(Set<Employee> employees);
}
