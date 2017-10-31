package project.domain.pojo.employees.managers;

import project.NotNullByDefault;
import project.domain.pojo.employees.AbstractEmployee;
import project.domain.pojo.organizations.Organization;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@NotNullByDefault
class LogisticManager extends AbstractEmployee implements Manager{

    public LogisticManager() {}

    public LogisticManager(int id, String name, String surname, String position, Organization organization) {
        super(id, name, surname, position, organization);
    }

    @Override
    public String manage() {
        //will be wrote later
        return "manage";
    }

    public Manager newInstance() {
        return new LogisticManager();
    }
}
