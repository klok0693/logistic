package project.domain.entity.pojo.cargo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.Entity;
import project.domain.entity.pojo.cargo.box.BoxCargo;
import project.domain.entity.pojo.cargo.oil.OilCargo;
import project.domain.entity.pojo.cargo.product.ProductCargo;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.storehouse.StoreHouse;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * Base interface for all cargo objects;
 * Hibernate mapped-superclass;
 */
@NotNullByDefault

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "name"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BoxCargo.class,      name = "BoxCargo"),
        @JsonSubTypes.Type(value = OilCargo.class,      name = "OilCargo"),
        @JsonSubTypes.Type(value = ProductCargo.class,  name = "ProductCargo")
})
public interface Cargo extends Entity, Instance<Cargo> {

    int getId();
    void setId(int id);

    String getType();
    void setType(String type);

    Date getProductionDate();
    void setProductionDate(Date productionDate);

    Date getShelfLife();
    void setShelfLife(Date shelfLife);

    Client getOwner();
    void setOwner(Client owner);

    StoreHouse getStore();
    void setStore(StoreHouse store);

    int getSize();
    void setSize(int size);

    String getFormat();
    void setFormat(String format);

    String getName();
    void setName(String name);
}
