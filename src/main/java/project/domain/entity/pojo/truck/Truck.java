package project.domain.entity.pojo.truck;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.Entity;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organization.Organization;
import project.domain.entity.pojo.truck.trucks.RefrigeratedTruck;
import project.domain.entity.pojo.truck.trucks.TankTruck;
import project.domain.entity.pojo.truck.trucks.TentedTruck;

import java.util.Set;

/**
 * Created by klok on 17.10.17.
 * Base interface for all trucks;
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
        @JsonSubTypes.Type(value = RefrigeratedTruck.class,  name = "RefrigeratedTruck"),
        @JsonSubTypes.Type(value = TankTruck.class,          name = "TankTruck"),
        @JsonSubTypes.Type(value = TentedTruck.class,        name = "TentedTruck")
})
public interface Truck<V extends Cargo> extends Entity, Instance<Truck<V>> {

    void setCargo(Set<V> cargo);
    Set<V> getCargo();

    int getId();
    void setId(int id);

    int getRegisterNumber();
    void setRegisterNumber(int registerNumber);

    String getModel();
    void setModel(String model);

    String getTrailer();
    void setTrailer(String trailer);

    @JsonBackReference(value = "TrucksSet")
    Organization getOrganization();
    void setOrganization(Organization organization);

    String getName();
    void setName(String name);
}
