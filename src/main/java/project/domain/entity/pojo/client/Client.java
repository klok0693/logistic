package project.domain.entity.pojo.client;

import com.fasterxml.jackson.annotation.JsonBackReference;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.Entity;
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
public interface Client extends Entity, Instance<Client>, Authentication {

    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    Organization getOrganization();
    void setOrganization(Organization organization);

    @JsonBackReference
    Set<Cargo> getCargoSet();
    void setCargoSet(Set<Cargo> cargoSet);
}
