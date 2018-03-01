package project.domain.entity.pojo.client;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.ejb.authentication.Authentication;
import project.domain.entity.pojo.cargo.Cargo;

import java.util.Set;

/**
 * Created by klok on 18.10.17.
 * Base interface for all clients;
 * Hibernate mapped-superclass;
 */
@NotNullByDefault

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "name" //defaultImpl = LogisticClient.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LogisticClient.class, name = "LogisticClient")
})
public interface Client extends Instance<Client>, Authentication {

    int getId();
    void setId(int id);

    String getType();
    void setType(String type);

    //Organization getOrganization();
    //void setOrganization(Organization organization);

    @JsonBackReference(value = "CargoSet")
    Set<Cargo> getCargoSet();
    void setCargoSet(Set<Cargo> cargoSet);
    void addCargo(Cargo cargo);

    String getName();
    //void setName(String name);
}
