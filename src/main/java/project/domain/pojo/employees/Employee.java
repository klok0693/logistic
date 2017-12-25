package project.domain.pojo.employees;

import com.fasterxml.jackson.annotation.JsonBackReference;
import project.NotNullByDefault;
import project.domain.Instance;
import project.domain.pojo.Entity;
import project.domain.pojo.organizations.Organization;

/**
 * Created by klok on 17.10.17.
 * Base interface for all employee;
 * Hibernate mapped-super-class;
 */
@NotNullByDefault
public interface Employee<V extends Employee<V>> extends Entity, Instance<V> {

    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    String getSurname();
    void setSurname(String surname);

    String getPosition();
    void setPosition(String position);

    @JsonBackReference
    Organization getOrganization();
    void setOrganization(Organization organization);
}
