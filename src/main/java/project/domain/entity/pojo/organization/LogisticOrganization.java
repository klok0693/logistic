package project.domain.entity.pojo.organization;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import project.aspect.NotNullByDefault;
import project.domain.entity.pojo.client.Client;
import project.domain.entity.pojo.employee.Employee;
import project.domain.entity.pojo.truck.Truck;

import java.util.Set;

/**
 * Created by klok on 17.10.17.
 * Hibernate entity;
 * Here i have been used annotation preprocessor, for more information
 * see https://projectlombok.org or https://habrahabr.ru/post/142356/;
 */
//TODO: separate organization on two table - with one-to-one reference,
//one table with basic information, one with other, or use discriminator.
@NotNullByDefault

@Getter @Setter
@EqualsAndHashCode(of = {"name", "owner"})
public class LogisticOrganization implements Organization {
    private volatile int     id;
    private volatile String  type;
    private volatile String  owner;
    private volatile String  name;

    private volatile Set<Truck>    trucks;
    private volatile Set<Client>   clients;
    private volatile Set<Employee> employees;

    public LogisticOrganization() {
        this.name = "LogisticOrganization";
    }

    public LogisticOrganization(String name, String owner, int id) {
        this.name   = name;
        this.owner  = owner;
        this.id     = id;
        this.name   = "LogisticOrganization";
    }

    @Override
    public Organization newInstance() {
        return new LogisticOrganization();
    }
}
