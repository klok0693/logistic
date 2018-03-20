package project.aspect;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import project.factory.Factory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by klok on 2.2.18.
 * Mark's methods for ExceptionAspect
 */
@NotNullByDefault

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CatchException {
    String message() default "";
}


/*
*This aspect catch's method exception's,
*log's they, and throw's custom exception
*/
@NotNullByDefault
@Log4j
@Aspect
class ExceptionAspect {

    @Pointcut("@annotation(project.aspect.CatchException)")
    public void Pointcut() {}

    @Around(value = "Pointcut()")
    public <E extends Throwable> Object LogMessage(ProceedingJoinPoint joinPoint) throws E {

        try {
            return joinPoint.proceed();
        }
        catch (Throwable throwable) {
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

            String message = method.getAnnotation(CatchException.class).message();
            if(!message.isEmpty()) log.error(message, throwable);

            //type of exception is first signature of method's throw-section
            Class<Exception> eClass = (Class<Exception>) method.getExceptionTypes()[0];
            throw (E) Factory.getException(eClass);
        }
    }
}
