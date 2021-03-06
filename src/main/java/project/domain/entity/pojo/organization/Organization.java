package project.domain.entity.pojo.organization;

import com.fasterxml.jackson.annotation.*;
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

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "name"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LogisticOrganization.class, name = "LogisticOrganization")
})
public interface Organization extends Entity, Instance<Organization> {

    int getId();
    void setId(int id);

    String getType();
    void setType(String type);

    String getOwner();
    void setOwner(String owner);

    @JsonIgnore
    //@JsonManagedReference(value= "TrucksSet")
    Set<Truck> getTrucks();
    void setTrucks(Set<Truck> trucks);

    @JsonIgnore
    @JsonManagedReference(value = "ClientsSet")
    Set<Client> getClients();
    void setClients(Set<Client> clients);

    @JsonIgnore
    @JsonManagedReference(value = "EmployeesSet")
    Set<Employee> getEmployees();
    void setEmployees(Set<Employee> employees);

    String getName();
    void setName(String name);
}
