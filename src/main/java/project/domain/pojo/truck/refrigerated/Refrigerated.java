package project.domain.pojo.truck.refrigerated;

import project.NotNullByDefault;
import project.domain.pojo.cargo.products.Product;
import project.domain.pojo.truck.Truck;

/**
 * Created by klok on 17.10.17.
 * interface for refrigerated trucks
 */
@NotNullByDefault
public interface Refrigerated extends Truck<Product, Refrigerated> {}
