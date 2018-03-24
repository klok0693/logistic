package project.domain.entity.pojo.storehouse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;

import java.util.Set;

/**
 * Created by klok on 24.3.18.
 */
@NotNullByDefault

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "name"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CargoStoreHouse.class, name = "CargoStoreHouse")
})
public interface StoreHouse {

    int getId();
    void setId(int id);

    String getAddress();
    void setAddress(String address);

    String getName();
    void setName(String name);

    Integer getSize();
    void setSize(Integer size);

    @JsonBackReference(value = "StoreCargoSet")
    Set<Cargo> getCargoSet();
    void setCargoSet(Set<Cargo> cargoSet);
}
