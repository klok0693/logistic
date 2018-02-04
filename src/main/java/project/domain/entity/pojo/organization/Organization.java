package project.domain.entity.pojo.organization;

import com.fasterxml.jackson.annotation.JsonBackReference;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.Entity;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.employee.Employee;
import project.domain.entity.pojo.truck.Truck;

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

    @JsonBackReference
    Set<Truck> getTrucks();
    void setTrucks(Set<Truck> trucks);

    @JsonBackReference
    Set<Client> getClients();
    void setClients(Set<Client> clients);

    @JsonBackReference
    Set<Employee> getEmployees();
    void setEmployees(Set<Employee> employees);
}
