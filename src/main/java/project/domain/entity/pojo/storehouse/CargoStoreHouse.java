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
    private int id;
    private String address, name;
    private Integer size;

    Set<Cargo> cargoSet;

    public CargoStoreHouse() {
        this.name = "CargoStoreHouse";
    }

    public CargoStoreHouse(int id, String address, Integer size) {
        this.id       = id;
        this.address  = address;
        this.name     = "CargoStoreHouse";
        this.size     = size;
    }
}
