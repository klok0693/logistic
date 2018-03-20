package project.model.data;

import project.aspect.NotNullByDefault;

/**
 * Created by klok on 27.10.17.
 */
@NotNullByDefault
public class DataException extends Exception {

    public DataException() {}

    public DataException(String s) {
        super(s);
    }

    public DataException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DataException(Throwable throwable) {
        super(throwable);
    }

    public DataException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
