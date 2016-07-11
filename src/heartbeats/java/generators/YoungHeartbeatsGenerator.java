package heartbeats.java.generators;

/**
 * Created by Beata Iłowiecka on 11.07.16.
 */
public class YoungHeartbeatsGenerator implements HeartbeatsGenerator {

    int heartbeats;

    int infantHeartbeatsPerMinute = 130;
    int childHeartbeatsPerMinute = 100;
    int teenagerHeartbeatsPerMinute = 85;

    public YoungHeartbeatsGenerator(int minutes, int phaseNr) {
        this.heartbeats = generateHeartbeats(minutes, phaseNr);
    }

    @Override
    public int getHeartbeats() {
        return heartbeats;
    }

    public int generateHeartbeats(int minutes, int phaseNr) {
        switch (phaseNr) {
            case 1:
                return infantHeartbeatsPerMinute * minutes;
            case 2:
                return childHeartbeatsPerMinute * minutes;
            case 3:
                return teenagerHeartbeatsPerMinute * minutes;
            default:
                throw new IllegalArgumentException("No such phase in YoungPhaseGenerator: " + phaseNr);
        }
    }
}
