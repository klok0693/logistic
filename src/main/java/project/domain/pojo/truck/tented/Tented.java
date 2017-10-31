package project.domain.pojo.truck.tented;

import project.NotNullByDefault;
import project.domain.pojo.cargo.box.Box;
import project.domain.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * interface for tented trucks
 */
@NotNullByDefault
public interface Tented extends Truck<Box, Tented> {}
