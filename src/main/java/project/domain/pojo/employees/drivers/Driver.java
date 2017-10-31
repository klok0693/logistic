package project.domain.pojo.employees.drivers;

import project.NotNullByDefault;
import project.domain.pojo.employees.Employee;

/**
 * Created by klok on 17.10.17.
 */
@NotNullByDefault
public interface Driver extends Employee<Driver> {

    String drive();
}
