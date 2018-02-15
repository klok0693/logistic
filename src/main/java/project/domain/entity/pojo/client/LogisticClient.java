package project.domain.entity.pojo.client;

import lombok.*;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.User;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organization.Organization;

import java.util.Set;

/**
 * Created by klok on 18.10.17.
 * Base class for all clients;
 * Hibernate entity;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@Getter @Setter
@EqualsAndHashCode(exclude = {"id", "cargoSet"})
public class LogisticClient implements Client {
    private volatile int          id;
    private volatile String       type,
                                  name;
    private volatile Organization organization;
    private volatile User         user;

    private Set<Cargo> cargoSet;

    public LogisticClient() {
        this.name = "LogisticClient";
    }

    public LogisticClient(int id, String type, Organization organization) {
        this.id            = id;
        this.type          = type;
        this.organization  = organization;
        this.name          = "LogisticClient";
    }

    @Override
    public Client newInstance() {
        return new LogisticClient();
    }
}
