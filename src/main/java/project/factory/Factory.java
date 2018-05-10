package project.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.domain.entity.ejb.authentication.Authentication;
import project.model.data.EntityData;
import project.model.data.objects.cargo.CargoData;
import project.model.data.objects.client.ClientData;
import project.model.data.objects.storehouse.StoreHouseData;
import project.model.data.users.UserData;
import project.model.service.rest.EntityService;
import project.model.service.rest.GenericEntityService;
import project.model.service.rest.objects.cargo.CargoService;
import project.model.service.rest.objects.client.ClientService;
import project.model.service.rest.objects.storehouse.StoreHouseService;
import project.model.service.rest.users.GenericUserService;
import project.model.service.rest.users.UserService;

/**
 * Created by klok on 11.10.17.
 * Singleton-class, generated Spring bean's, accessed by static method's get factory()
 */
@NotNullByDefault
public class Factory implements ApplicationContextAware {
    private static ApplicationContext context;

    static { getFactory().setApplicationContext("root-context.xml"); }

    private Factory() {}

    private Factory(String contextWay) {
        setApplicationContext(contextWay);
    }

    private Factory(ApplicationContext context) {
        this.context = context;
    }

    private static class FactoryHolder{
        private static final Factory factory = new Factory();
    }

    public static Factory getFactory() { return FactoryHolder.factory; }


    //example: getClass(Client.class) -> return GenericDao<Client>
    public static <T extends Entity> EntityData<T> getData(Class<T> aClass) {
        return ((EntityData) context.getBean("entityData")).setEntityClass(aClass);
    }


    public static <T extends Authentication> UserData<T> getUserData(Class<T> aClass) {
        UserData<T> userData = (UserData) context.getBean("userData");
        userData.setEntityClass(aClass);
        return userData;
    }


    //example: getEntity(TruckDriver.class) -> return TruckDriver
    public static <T extends Entity> T getEntity(Class<T> aClass) {
        return context.getBean(aClass);
    }


    //example: getService(Client.class) -> return Service<Client>
    public static <T extends Entity> EntityService<T> getService(Class<T> aClass) {
        GenericEntityService service = (GenericEntityService) context.getBean("entityService");
        service.setData(getData(aClass));
        return service;
    }


    //example: getUserService(Client.class) -> return UserService<Client>
    public static <T extends Authentication> UserService<T> getUserService(Class<T> aClass) {
        GenericUserService service = (GenericUserService) context.getBean("userService");
        service.setData(getUserData(aClass));
        return service;
    }


    public static CargoData getCargoData() {
        return context.getBean(CargoData.class);
    }

    public static ClientData getClientData() {
        return context.getBean(ClientData.class);
    }

    public static StoreHouseData getStoreHouseData() {
        return context.getBean(StoreHouseData.class);
    }

    public static CargoService getCargoService() {
        return context.getBean(CargoService.class);
    }

    public static ClientService getClientService() {
        return context.getBean(ClientService.class);
    }

    public static StoreHouseService getStoreHouseService() {
        return context.getBean(StoreHouseService.class);
    }


    //return's custom exception
    public static <T extends Exception> T getException(Class<T> tClass) {
        return context.getBean(tClass);
    }



    public void setApplicationContext(String contextWay){
        FactoryHolder.factory.context = new ClassPathXmlApplicationContext(contextWay);
    }

    public void setApplicationContext(ApplicationContext context){
        FactoryHolder.factory.context = context;
    }
}