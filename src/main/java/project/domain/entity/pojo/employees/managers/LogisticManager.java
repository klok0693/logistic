package project.domain.entity.pojo.employees.managers;

import lombok.Getter;
import lombok.Setter;
import project.NotNullByDefault;
import project.domain.entity.ejb.authentication.User;
import project.domain.entity.pojo.employees.AbstractEmployee;
import project.domain.entity.pojo.organizations.Organization;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@Getter @Setter
@NotNullByDefault
class LogisticManager extends AbstractEmployee implements Manager{
    private User user;

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
