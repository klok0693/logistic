package project.domain.entity.pojo.storehouse;

import lombok.*;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;

import java.util.Set;

/**
 * Created by klok on 24.3.18.
 */
@NotNullByDefault

@ToString(of = {"id","address", "size"})
@Getter @Setter
@EqualsAndHashCode(exclude = {"id", "cargoSet"})
public class CargoStoreHouse implements StoreHouse{
    private volatile int id;
    private volatile String address, name;
    private volatile Integer size;

    private volatile Set<Cargo> cargoSet;

    public CargoStoreHouse() {
        this.name = "CargoStoreHouse";
    }

    public CargoStoreHouse(int id, String address, Integer size) {
        this.id       = id;
        this.address  = address;
        this.name     = "CargoStoreHouse";
        this.size     = size;
    }

    @Override
    public StoreHouse newInstance() {
        return new CargoStoreHouse();
    }
}
