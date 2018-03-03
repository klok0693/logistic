package project.domain.entity.pojo.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.User;

/**
 * Created by klok on 18.10.17.
 * Base class for all clients;
 * Hibernate entity;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@ToString(of = {"id","type" /*"organization"*/})
@Getter @Setter
@EqualsAndHashCode(exclude = {"id" /*"cargoSet"*/})
public class LogisticClient implements Client {
    private volatile int          id;
    private volatile String       type;
    //private volatile Organization organization;
    private volatile User user;

    //private Set<Cargo> cargoSet;

    private final String name = "LogisticClient";

    public LogisticClient() {}

    public LogisticClient(String s) {}

    public LogisticClient(int id, String type /*, Organization organization*/) {
        this.id            = id;
        this.type          = type;
        //this.organization  = organization;
    }

    /*@Override
    public void addCargo(Cargo cargo) {
        cargoSet.add(cargo);
    }*/

    @Override
    public Client newInstance() {
        return new LogisticClient();
    }
}
