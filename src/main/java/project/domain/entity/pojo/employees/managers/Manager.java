package project.domain.entity.pojo.employees.managers;

import project.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.domain.entity.pojo.employees.Employee;

/**
 * Created by klok on 17.10.17.
 */
@NotNullByDefault
public interface Manager extends Employee<Manager>, Authentication {

    String manage();


}
