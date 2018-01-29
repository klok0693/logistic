package project.domain.entity;

import project.NotNullByDefault;

/**
 * Created by klok on 25.10.17.
 */
@NotNullByDefault
public interface Entity {

    int getId();
    void setId(int id);
}
