package heartbeats.java.generators;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class WomanHeartbeatsGenerator implements HeartbeatsGenerator {

    MultiMap<String, Integer> womanHeartbeatsPerMinute = new MultiValueMap<>();

    int heartbeats;
    int condition;

    public WomanHeartbeatsGenerator(int minutes, int condition, int phaseNr) {
        this.womanHeartbeatsPerMinute.put("1", new Integer[]{57, 56, 56, 57, 56, 56});
        this.womanHeartbeatsPerMinute.put("2", new Integer[]{63, 62, 62, 63, 62, 62});
        this.womanHeartbeatsPerMinute.put("3", new Integer[]{68, 66, 67, 68, 66, 66});
        this.womanHeartbeatsPerMinute.put("4", new Integer[]{72, 70, 72, 72, 71, 70});
        this.womanHeartbeatsPerMinute.put("5", new Integer[]{76, 74, 76, 76, 76, 74});
        this.womanHeartbeatsPerMinute.put("6", new Integer[]{82, 80, 82, 80, 80, 80});
        this.womanHeartbeatsPerMinute.put("7", new Integer[]{85, 83, 85, 84, 84, 84});
    }

    @Override
    public int getHeartbeats() {
        return heartbeats; // minutes * kondycja[phaseNr.transform()]
    }

    public int generateHeartbeats() {
        return 0;
    }
}
