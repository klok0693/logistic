package project.domain.entity.pojo.organizations;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import project.NotNullByDefault;
import project.domain.entity.pojo.clients.Client;
import project.domain.entity.pojo.employees.Employee;
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
    private int     id;
    private String  name;
    private String  owner;

    private Set<Truck>    trucks;
    private Set<Client>   clients;
    private Set<Employee> employees;

    public LogisticOrganization() {}

    public LogisticOrganization(String name, String owner, int id) {
        this.name   = name;
        this.owner  = owner;
        this.id     = id;
    }

    @Override
    public Organization newInstance() {
        return new LogisticOrganization();
    }

    @Override
    public String toString() {
        return name+" "+owner;
    }
}
