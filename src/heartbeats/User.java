package heartbeats;

import java.util.Date;
import java.util.concurrent.locks.Condition;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class User {

    private Gender gender;
    private int heartbeats;
    private Date dateOfBirth;
    private Condition condition;
    private Life life;

}
