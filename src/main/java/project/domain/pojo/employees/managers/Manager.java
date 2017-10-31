package project.domain.pojo.employees.managers;

import project.NotNullByDefault;
import project.domain.pojo.employees.Employee;

/**
 * Created by klok on 17.10.17.
 */
@NotNullByDefault
public interface Manager extends Employee<Manager> {

    String manage();
}
