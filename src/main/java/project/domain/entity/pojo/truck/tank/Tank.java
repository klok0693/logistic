package project.domain.entity.pojo.truck.tank;

import project.NotNullByDefault;
import project.domain.entity.pojo.cargo.oil.Oil;
import project.domain.entity.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * interface for taf trucks
 */
@NotNullByDefault
public interface Tank extends Truck<Oil, Tank> {}
