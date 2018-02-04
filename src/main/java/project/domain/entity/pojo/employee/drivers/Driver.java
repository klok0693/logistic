package project.domain.entity.pojo.employee.drivers;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.employee.Employee;

/**
 * Created by klok on 17.10.17.
 */
@NotNullByDefault
public interface Driver extends Employee<Driver> {

    String drive();

    String getDriveCard();
    void setDriveCard(String driveCard);
}
