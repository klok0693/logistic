package project.domain.entity.pojo.employee.managers;

import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.Authentication;
import project.domain.entity.pojo.employee.Employee;

/**
 * Created by klok on 17.10.17.
 */
@NotNullByDefault
public interface Manager extends Employee<Manager>, Authentication {

    String manage();


}
