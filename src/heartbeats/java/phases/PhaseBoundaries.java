package heartbeats.java.phases;

import java.util.Date;

/**
 * Created by Beata Iłowiecka on 11.07.16.
 */
public class PhaseBoundaries {

    private Date dateOfBirth;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    Date infantStart = new Date(year, month, day, hour, minute, 0);
    public Date childStart = new Date(year + 1, month, day, hour, minute, 0);
    Date teenagerStart = new Date(year + 10, month, day, hour, minute, 0);
    Date start_18_25 = new Date(year + 18, month, day, hour, minute, 0);
    Date start_26_35 = new Date(year + 25, month, day, hour, minute, 0);
    Date start_36_45 = new Date(year + 35, month, day, hour, minute, 0);
    Date start_46_55 = new Date(year + 45, month, day, hour, minute, 0);
    Date start_56_65 = new Date(year + 55, month, day, hour, minute, 0);
    Date start_65_plus = new Date(year + 65, month, day, hour, minute, 0);

    public PhaseBoundaries(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.year = dateOfBirth.getYear();
        this.month = dateOfBirth.getMonth();
        this.day = dateOfBirth.getDay();
        this.hour = dateOfBirth.getHours();
        this.minute = dateOfBirth.getMinutes();
    }

    public long getPhaseDuration(int phaseNr) {
        switch (phaseNr) {
            case 1:
                return childStart.getTime() - infantStart.getTime();
            case 2:
                return teenagerStart.getTime() - childStart.getTime();
            case 3:
                return start_18_25.getTime() - teenagerStart.getTime();
            case 4:
                return start_26_35.getTime() - start_18_25.getTime();
            case 5:
                return start_36_45.getTime() - start_26_35.getTime();
            case 6:
                return start_46_55.getTime() - start_36_45.getTime();
            case 7:
                return start_56_65.getTime() - start_46_55.getTime();
            case 8:
                return start_65_plus.getTime() - start_56_65.getTime();
            default:
                throw new IllegalArgumentException("Wrong phase number");
        }
    }
}
