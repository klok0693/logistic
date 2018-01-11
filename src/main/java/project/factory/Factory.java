package project.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.NotNullByDefault;
import project.domain.entity.pojo.cargo.Cargo;
import project.domain.entity.pojo.cargo.box.Box;
import project.domain.entity.pojo.cargo.oil.Oil;
import project.domain.entity.pojo.cargo.products.Product;
import project.domain.entity.pojo.clients.Client;
import project.domain.entity.pojo.employees.Employee;
import project.domain.entity.pojo.employees.drivers.Driver;
import project.domain.entity.pojo.employees.managers.Manager;
import project.domain.entity.pojo.organizations.Organization;
import project.domain.entity.pojo.truck.Truck;
import project.domain.entity.pojo.truck.refrigerated.Refrigerated;
import project.domain.entity.pojo.truck.tank.Tank;
import project.domain.entity.pojo.truck.tented.Tented;
import project.model.data.GenericDao;

/**
 * Created by klok on 11.10.17.
 * Singleton-class, generated Spring bean's, accessed by static method's get factory()
 */
@NotNullByDefault
public class Factory {
    private ApplicationContext context;

    private Factory(String contextWay) {
        setContext(contextWay);
    }

    private Factory(ApplicationContext context) {
        this.context = context;
    }

    private Factory() {}

    private static class FactoryHolder{
        private static final Factory factory = new Factory();
    }

    public static Factory getFactory(String contextWay) {
        Factory factory = FactoryHolder.factory;
        factory.setContext(contextWay);
        return factory;
    }

    public static Factory getFactory(ApplicationContext context) {
        Factory factory = FactoryHolder.factory;
        factory.context = context;
        return factory;
    }



    public Tented getTentedTruck() {
        return (Tented) context.getBean("tentedTruck");
    }

    public Tank getTankTruck() {
        return (Tank) context.getBean("tankTruck");
    }

    public Refrigerated getRefrigeratedTruck() {
        return (Refrigerated) context.getBean("refrigeratedTruck");
    }

    public Organization getOrganization() {
        return (Organization) context.getBean("organization");
    }

    public Box getBox() {
        return (Box) context.getBean("box");
    }

    public Oil getOil() {
        return (Oil) context.getBean("oil");
    }

    public Product getProduct() {
        return (Product) context.getBean("product");
    }

    public Driver getDriver() {
        return (Driver) context.getBean("driver");
    }

    public Manager getManager() {
        return (Manager) context.getBean("Manager");
    }

    public Client getClient() {
        return (Client) context.getBean("client");
    }



    public GenericDao<Cargo> getCargoData() {
        return (GenericDao<Cargo>) context.getBean("cargoData");
    }

    public GenericDao<Client> getClientData() {
        return (GenericDao<Client>) context.getBean("clientData");
    }

    public GenericDao<Employee> getEmployeeData() {
        return (GenericDao<Employee>) context.getBean("employeeData");
    }

    public GenericDao<Organization> getOrganizationData() {
        return (GenericDao<Organization>) context.getBean("organizationData");
    }

    public GenericDao<Truck> getTruckData() {
        return (GenericDao<Truck>) context.getBean("truckData");
    }



    private void setContext(String context) {
        this.context = new ClassPathXmlApplicationContext(context);
    }
}
