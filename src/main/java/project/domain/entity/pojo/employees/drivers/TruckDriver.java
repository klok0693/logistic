package project.domain.entity.pojo.employees.drivers;

import project.NotNullByDefault;
import project.domain.entity.pojo.employees.AbstractEmployee;
import project.domain.entity.pojo.organizations.Organization;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@NotNullByDefault
class TruckDriver extends AbstractEmployee implements Driver {

    public TruckDriver() {}

    public TruckDriver(int id, String name, String surname, String position , Organization organization) {
        super(id, name, surname, position, organization);
    }

    @Override
    public String drive() {
        //will be wrote later
        return "wrrr";
    }

    @Override
    public Driver newInstance() {
        return new TruckDriver();
    }
}
