package project.domain;

import project.aspect.NotNullByDefault;

/**
 * Created by klok on 17.10.17.
 */
@NotNullByDefault
public interface Instance<V extends Instance<V>> {

    V newInstance();
}
