package heartbeats.java.phases;

import heartbeats.java.Condition;
import heartbeats.java.Gender;

import java.util.Date;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class Phase {

    private int minutes;
    protected int heartbeats;

    public Phase(int minutes) {
    }

    public int getHeartbeats() {
        return heartbeats;
    }
}
