package project.model.data;

import project.aspect.NotNullByDefault;

/**
 * Created by klok on 27.10.17.
 */
@NotNullByDefault
public class DaoException extends Exception {

    public DaoException() {}

    public DaoException(String s) {
        super(s);
    }

    public DaoException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DaoException(Throwable throwable) {
        super(throwable);
    }

    public DaoException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
