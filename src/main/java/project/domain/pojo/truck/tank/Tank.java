package project.domain.pojo.truck.tank;

import project.NotNullByDefault;
import project.domain.pojo.cargo.oil.Oil;
import project.domain.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * interface for taf trucks
 */
@NotNullByDefault
public interface Tank extends Truck<Oil, Tank> {}
