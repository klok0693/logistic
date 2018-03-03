package project.domain.entity.pojo.cargo;

import lombok.*;
import project.aspect.NotNullByDefault;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * hibernate entity
 */
@NotNullByDefault

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class BoxCargo {
    protected volatile Integer    id,
            size;
    protected volatile String type,
            format,
            name = "BoxCargo";
    protected volatile Date   productionDate,
            shelfLife;

    public BoxCargo() {}

    public BoxCargo(int size, String type, String format, Date productionDate, Date shelfLife) {
        this.size = size;
        this.type = type;
        this.format = format;
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
    }

    public BoxCargo newInstance() {
        return new BoxCargo();
    }

    @Override
    public String toString() {
        String i;
        return "id = " +id+" "+type+" "+size;
    }
}
