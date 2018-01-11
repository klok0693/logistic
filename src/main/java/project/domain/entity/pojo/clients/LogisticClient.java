package project.domain.entity.pojo.clients;

import lombok.*;
import project.NotNullByDefault;
import project.domain.entity.ejb.authentication.User;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organizations.Organization;

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
class LogisticClient implements Client {
    private int          id;
    private String       name;
    private Organization organization;
    private User         user;

    private Set<Cargo> cargoSet;

    public LogisticClient() {}

    public LogisticClient(int id, String name, Organization organization) {
        this.id            = id;
        this.name          = name;
        this.organization  = organization;
    }

    @Override
    public Client newInstance() {
        return new LogisticClient();
    }

    @Override
    public String toString() {
        return name+" "+organization.getName();
    }
}
