package project.domain.entity.pojo.employee.drivers;

import lombok.Getter;
import lombok.Setter;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.employee.AbstractEmployee;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@Getter @Setter
@NotNullByDefault
public class TruckDriver extends AbstractEmployee implements Driver {
    private String driveCard;

    public TruckDriver() {
        super("TruckDriver");
    }

    public TruckDriver(int id, String name, String surname, String position) {
        super(id, "TruckDriver", name, surname, position);
    }

    @Override
    public String drive() {
        //will be written later
        return "wrrr";
    }

    @Override
    public Driver newInstance() {
        return new TruckDriver();
    }
}
