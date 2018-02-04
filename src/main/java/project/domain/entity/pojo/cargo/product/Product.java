package project.domain.entity.pojo.cargo.product;

import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;

/**
 * Created by klok on 4.2.18.
 */
@NotNullByDefault
public interface Product extends Cargo<Product> {
}
