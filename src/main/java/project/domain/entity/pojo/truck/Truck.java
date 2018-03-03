package project.domain.entity.pojo.truck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.Entity;
import project.domain.entity.pojo.truck.refrigerated.RefrigeratedTruck;
import project.domain.entity.pojo.truck.tank.TankTruck;
import project.domain.entity.pojo.truck.tented.TentedTruck;

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
public interface Truck extends Entity, Instance<Truck> {

    /*void loadCargo(Set<Cargo> cargo);
    Set<Cargo> takeCargo();*/

    int getId();
    void setId(int id);

    int getRegisterNumber();
    void setRegisterNumber(int registerNumber);

    String getModel();
    void setModel(String model);

    String getTrailer();
    void setTrailer(String trailer);

    /*@JsonBackReference(value = "TruckOrganization")
    Organization getOrganization();
    void setOrganization(Organization organization);*/

    String getName();
    void setName(String name);
}
