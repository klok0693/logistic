package project.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.GenericDao;

/**
 * Created by klok on 11.10.17.
 * Singleton-class, generated Spring bean's, accessed by static method's get factory()
 */
@NotNullByDefault
public class Factory {
    private ApplicationContext context;

    private Factory() {}

    private Factory(String contextWay) {
        this.context = new ClassPathXmlApplicationContext(contextWay);
    }

    private Factory(ApplicationContext context) {
        this.context = context;
    }

    private static class FactoryHolder{
        private static final Factory factory = new Factory();
    }


    //example: getClass(Client.class) -> return GenericDao<Client>
    public <T extends Entity> GenericDao<T> getData(Class<T> aClass) {
        GenericDao data = (GenericDao<?>) context.getBean("data");
        return data.setEntityClass(aClass);
    }

    //example: getEntity(TruckDriver.class) -> return TruckDriver
    public <T extends Entity> T getEntity(Class<T> aClass) {
        return context.getBean(aClass);
    }



    public static Factory getFactory() {
        return FactoryHolder.factory;
    }

    public static Factory setApplicationContext(String contextWay){
        FactoryHolder.factory.context = new ClassPathXmlApplicationContext(contextWay);
        return FactoryHolder.factory;
    }

    public static Factory setApplicationContext(ApplicationContext context){
        FactoryHolder.factory.context = context;
        return FactoryHolder.factory;
    }
}
