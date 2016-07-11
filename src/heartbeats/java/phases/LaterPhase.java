package heartbeats.java.phases;

import heartbeats.java.Gender;
import heartbeats.java.generators.HeartbeatsGenerator;
import heartbeats.java.generators.ManHeartbeatsGenerator;
import heartbeats.java.generators.WomanHeartbeatsGenerator;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class LaterPhase extends Phase {

    HeartbeatsGenerator heartbeatsGenerator;

    public LaterPhase(int minutes, Gender gender, int condition, int phaseNr) {
        super(minutes);
        this.heartbeatsGenerator = createGenerator(gender, condition, phaseNr);
        this.heartbeats = heartbeatsGenerator.getHeartbeats();
    }

    private HeartbeatsGenerator createGenerator(Gender gender, int condition, int phaseNr) {
        if (gender == Gender.WOMAN)
            return new WomanHeartbeatsGenerator(condition, phaseNr);
        else if (gender == Gender.MAN)
            return new ManHeartbeatsGenerator(condition, phaseNr);
        else
            throw new IllegalArgumentException("No such gender: in the system");
    }
}
