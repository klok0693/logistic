package project.domain.entity.pojo.employee.drivers;

import lombok.Getter;
import lombok.Setter;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.employee.AbstractEmployee;
import project.domain.entity.pojo.organization.Organization;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by klok on 11.10.17.
 * hibernate entity
 */
@NotNullByDefault

@Getter @Setter
public class TruckDriver extends AbstractEmployee implements Driver {

    @Size(min = 16, max = 16,   message="field must be 6 characters long")
    @Pattern(regexp="[0-9]",  message="field must be a number")
    private String driveCard;

    public TruckDriver() {
        super("TruckDriver");
    }

    public TruckDriver(int id, String name, String surname, String position , Organization organization) {
        super(id, "TruckDriver", name, surname, position, organization);
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
