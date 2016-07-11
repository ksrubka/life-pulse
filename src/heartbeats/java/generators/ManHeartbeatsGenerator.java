package heartbeats.java.generators;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class ManHeartbeatsGenerator implements HeartbeatsGenerator {

    MultiMap<String, Integer> manHeartbeatsPerMinute = new MultiValueMap<>();

    int heartbeats;
    int condition;

    public ManHeartbeatsGenerator(int minutes, int condition, int phaseNr) {
        this.manHeartbeatsPerMinute.put("1", new Integer[]{52, 52, 53, 54, 54, 52});
        this.manHeartbeatsPerMinute.put("2", new Integer[]{58, 58, 60, 60, 59, 58});
        this.manHeartbeatsPerMinute.put("3", new Integer[]{64, 64, 64, 66, 64, 64});
        this.manHeartbeatsPerMinute.put("4", new Integer[]{68, 68, 68, 70, 70, 68});
        this.manHeartbeatsPerMinute.put("5", new Integer[]{72, 72, 73, 74, 74, 72});
        this.manHeartbeatsPerMinute.put("6", new Integer[]{78, 78, 79, 80, 78, 76});
        this.manHeartbeatsPerMinute.put("7", new Integer[]{82, 82, 83, 84, 82, 80});
    }

    @Override
    public int getHeartbeats() {
        return heartbeats;
    }

    public int generateHeartbeats() {
        return 0; // minutes * kondycja[phaseNr.transform()]
    }
}
