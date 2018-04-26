package project.model.service;

import project.aspect.NotNullByDefault;

/**
 * Created by klok on 15.1.18.
 */
@NotNullByDefault
public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(String s) {
        super(s);
    }

    public ServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
