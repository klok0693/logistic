package project.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.aspect.NotNullByDefault;
import project.domain.entity.Entity;
import project.model.data.GenericDao;

/**
 * Created by klok on 11.10.17.
 * Singleton-class, generated Spring bean's, accessed by static method's get factory()
 */
@NotNullByDefault
public class Factory implements ApplicationContextAware {
    private static ApplicationContext context;

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

    public static Factory getFactory() {
        return FactoryHolder.factory;
    }



    //example: getClass(Client.class) -> return GenericDao<Client>
    public static <T extends Entity> GenericDao<T> getData(Class<T> aClass) {
        return ((GenericDao) context.getBean("data")).setEntityClass(aClass);
    }

    //example: getEntity(TruckDriver.class) -> return TruckDriver
    public static <T extends Entity> T getEntity(Class<T> aClass) {
        return context.getBean(aClass);
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
