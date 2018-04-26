package project.domain.entity.pojo.client;

import com.fasterxml.jackson.annotation.*;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.ejb.authentication.Authentication;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organization.Organization;

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

    //@JsonInclude
    //@JsonBackReference(value = "ClientsSet")
    Organization getOrganization();
    void setOrganization(Organization organization);

    //
    @JsonIgnore
    @JsonManagedReference(value = "CargoSet")
    Set<Cargo> getCargoSet();
    void setCargoSet(Set<Cargo> cargoSet);
    void addCargo(Cargo cargo);

    String getName();
    void setName(String name);
}
