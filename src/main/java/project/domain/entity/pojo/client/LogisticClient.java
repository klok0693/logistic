package project.domain.entity.pojo.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.aspect.NotNullByDefault;
import project.domain.entity.ejb.authentication.User;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.organization.Organization;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by klok on 18.10.17.
 * Base class for all clients;
 * Hibernate entity;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
@NotNullByDefault

@ToString(of = {"id","type", "organization"})
@Getter @Setter
@EqualsAndHashCode(exclude = {"id", "cargoSet"})
public class LogisticClient implements Client {

    private volatile int id;

    @Size(min = 2, max = 70,          message="field must be between 2 and 70 characters long.")
    @Pattern(regexp="[a-zA-Z0-9]+&",  message="field must be alphanumeric")
    private volatile String type, name;

    private volatile Organization organization;
    private volatile User user;

    private volatile Set<Cargo> cargoSet;

    public LogisticClient() {
        this.name  = "LogisticClient";
    }

    public LogisticClient(int id, String type , Organization organization) {
        this.id            = id;
        this.type          = type;
        this.name          = "LogisticClient";
        this.organization  = organization;
    }

    @Override
    public void addCargo(Cargo cargo) {
        cargoSet.add(cargo);
    }

    @Override
    public Client newInstance() {
        return new LogisticClient();
    }
}
