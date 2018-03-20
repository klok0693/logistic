package project.domain.entity.pojo.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.Entity;
import project.domain.entity.pojo.employee.drivers.TruckDriver;
import project.domain.entity.pojo.employee.managers.LogisticManager;
import project.domain.entity.pojo.organization.Organization;

/**
 * Created by klok on 17.10.17.
 * Base interface for all employee;
 * Hibernate mapped-super-class;
 */
@NotNullByDefault

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "name"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TruckDriver.class,      name = "TruckDriver"),
        @JsonSubTypes.Type(value = LogisticManager.class,  name = "LogisticManager"),
})
public interface Employee<V extends Employee<V>> extends Entity, Instance<V> {

    int getId();
    void setId(int id);

    String getType();
    void setType(String type);

    String getSurname();
    void setSurname(String surname);

    String getPosition();
    void setPosition(String position);

    @JsonBackReference(value = "EmployeeOrganization")
    Organization getOrganization();
    void setOrganization(Organization organization);

    String getName();
    void setName(String name);
}
