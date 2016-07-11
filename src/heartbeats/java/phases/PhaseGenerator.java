package heartbeats.java.phases;

import heartbeats.java.Gender;

import java.util.Date;
import java.util.List;

/**
 * Created by Beata Iłowiecka on 11.07.16.
 */
public class PhaseGenerator {

    private Date now = new Date();

    PhaseBoundaries phaseBoundaries;
    private Date dateOfBirth;
    Gender gender;
    int condition;
    private long length;
    private long lifeLeft;
    private long durationOfCalculatedPhases;
    private List<Phase> phases;

    public PhaseGenerator(Date dateOfBirth, int condition, Gender gender) {
        this.phaseBoundaries = new PhaseBoundaries(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.condition = condition;
        this.length = now.getTime() - dateOfBirth.getTime();
        this.lifeLeft = length;
    }

    private void generatePhases() {
        for (int phaseNr = 1; phaseNr >= 9; phaseNr++) {
            if (currentPhaseIsTheLastOne()) {
                if (phaseIsYoung(phaseNr))
                    generateLastYoungPhase(phaseNr);
                else
                    generateLastLaterPhase(phaseNr, gender);
            }
            else {
                if (phaseIsYoung(phaseNr))
                    generateWholeYoungPhase(phaseNr);
                else
                    generateWholeLaterPhase(phaseNr);
            }
        }
    }

    private boolean currentPhaseIsTheLastOne() {
        return false;
    }

    /*
    if age_child < lifespan <= age_teenager:
    life_left -= total
    phase_teenager += life_left

    elif lifespan >= age_teenager:
    phase_teenager += max_phase_teenager
    total += phase_teenager
    */

    private boolean phaseExists(int phaseNr) {
        return lifeLeft < phaseBoundaries.getPhaseDuration(phaseNr) ;
    }

    private boolean lifeLengthIsGreaterThanPhase(int phaseNr) {
        return length > (dateOfBirth.getTime() - phaseBoundaries.getPhaseDuration(phaseNr) );
    }

    private boolean phaseIsYoung(int phaseNr) {
        return phaseNr <= 3;
    }

    public List<Phase> getPhases() {
        return phases;
    }
}
