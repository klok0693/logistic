package project.domain.pojo.truck;

import com.fasterxml.jackson.annotation.JsonBackReference;
import project.NotNullByDefault;
import project.domain.Instance;
import project.domain.pojo.Entity;
import project.domain.pojo.cargo.Cargo;
import project.domain.pojo.organizations.Organization;

import java.util.List;

/**
 * Created by klok on 17.10.17.
 * Base interface for all trucks;
 * Hibernate mapped-superclass;
 */
@NotNullByDefault
public interface Truck<V extends Cargo,T extends Truck<V, T>> extends Entity, Instance<T> {

    void loadCargo(List<V> cargo);
    List<V> takeCargo();

    int getId();
    void setId(int id);

    int getRegisterNumber();
    void setRegisterNumber(int registerNumber);

    String getModel();
    void setModel(String model);

    String getTrailer();
    void setTrailer(String trailer);

    @JsonBackReference
    Organization getOrganization();
    void setOrganization(Organization organization);
}
