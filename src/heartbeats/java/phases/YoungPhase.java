package heartbeats.java.phases;

import heartbeats.java.generators.HeartbeatsGenerator;
import heartbeats.java.generators.YoungHeartbeatsGenerator;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class YoungPhase extends Phase  {

    private HeartbeatsGenerator heartbeatsGenerator;


    public YoungPhase(int minutes, int phaseNr) {
        super(minutes);
        this.heartbeatsGenerator = new YoungHeartbeatsGenerator(minutes, phaseNr);
    }

    public void generateHeartbeats() {
        heartbeatsGenerator.getHeartbeats();
    }
}
