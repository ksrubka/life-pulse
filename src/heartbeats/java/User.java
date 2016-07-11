package heartbeats.java;

import java.util.Date;


/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class User {

    private Life life;

    public User(Date dateOfBirth, int condition, Gender gender) {
        this.life = new Life(dateOfBirth, condition, gender);
    }

    public int getHeartbeats() {
        return life.getHeartbeats();
    }
}
