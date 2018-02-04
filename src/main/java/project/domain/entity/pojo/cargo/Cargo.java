package project.domain.entity.pojo.cargo;

import project.aspect.NotNullByDefault;
import project.domain.Instance;
import project.domain.entity.Entity;
import project.domain.entity.pojo.client.Client;

import java.util.Date;

/**
 * Created by klok on 12.10.17.
 * Base interface for all cargo objects;
 * Hibernate mapped-superclass;
 */
@NotNullByDefault
public interface Cargo<V extends Cargo<V>> extends Entity, Instance<V> {

    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    Date getProductionDate();
    void setProductionDate(Date productionDate);

    Date getShelfLife();
    void setShelfLife(Date shelfLife);

    Client getOwner();
    void setOwner(Client owner);

    int getSize();
    void setSize(int size);

    String getFormat();
    void setFormat(String format);
}
