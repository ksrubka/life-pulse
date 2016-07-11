package heartbeats.java;

import heartbeats.java.phases.Phase;
import heartbeats.java.phases.PhaseBoundaries;
import heartbeats.java.phases.PhaseGenerator;
import heartbeats.java.phases.YoungPhase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class Life {

    private List<Phase> phases = new ArrayList<>();
    private int heartbeats;

    public Life(Date dateOfBirth, int condition, Gender gender) {
        PhaseGenerator phaseGenerator = new PhaseGenerator(dateOfBirth, condition, gender);
        this.phases = phaseGenerator.getPhases();
        countHeartbeats();
    }

    private void countHeartbeats() {
        for (Phase phase: phases)
            heartbeats += phase.getHeartbeats();
    }

    public int getHeartbeats() {
        return heartbeats;
    }
}
