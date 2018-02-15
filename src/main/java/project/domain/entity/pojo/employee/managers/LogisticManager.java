package project.domain.entity.pojo.employee.managers;

import lombok.Getter;
import lombok.Setter;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.User;
import project.domain.entity.pojo.employee.AbstractEmployee;
import project.domain.entity.pojo.organization.Organization;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@Getter @Setter
@NotNullByDefault
public class LogisticManager extends AbstractEmployee implements Manager{
    private User user;

    public LogisticManager() {
        super("LogisticManager");
    }

    public LogisticManager(int id, String name, String surname, String position, Organization organization) {
        super(id, "LogisticManager", name, surname, position, organization);
    }

    @Override
    public String manage() {
        //will be written later
        return "manage";
    }

    public Manager newInstance() {
        return new LogisticManager();
    }
}
