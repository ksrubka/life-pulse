package heartbeats.java;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Beata Iłowiecka on 10.07.16.
 */
public class Application {

    public static void main(String[] args) {
        Date dateOfBirth = getDateOfBirthFromUser();
        Condition condition = getConditionFromUser();
        Gender gender = getGenderFromUser();

        User user = new User(dateOfBirth, condition, gender);
        System.out.println("During your life, You experienced " +
                user.getHeartbeats()/1000 +
                " thousand heartbeats");
    }

    public static Date getDateOfBirthFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter year of birth: ");
        int year = reader.nextInt();
        System.out.println("Enter month: ");
        int month = reader.nextInt();
        System.out.println("Enter day: ");
        int day = reader.nextInt();
        System.out.println("Enter hour: ");
        int hour = reader.nextInt();
        System.out.println("Enter minute: ");
        int minute = reader.nextInt();
        return new Date(year, month, day, hour, minute, 0);
    }

    public static Gender getGenderFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter gender (W/M): ");
        String gender = reader.next();
        if (gender.toUpperCase().equals("W"))
            return Gender.WOMAN;
        else if (gender.toUpperCase().equals("M"))
            return Gender.MAN;
        else
            throw new IllegalArgumentException("No such gender in the system.");
    }

    public static Condition getConditionFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Condition (rate it in scale from 1(great) to 6(bad)): ");
        int condition = reader.nextInt();
        switch(condition) {
            case 1:
                return Condition.GREAT;
            case 2:
                return Condition.VERY_GOOD;
            case 3:
                return Condition.GOOD;
            case 4:
                return Condition.AVERAGE;
            case 5:
                return Condition.POOR;
            case 6:
                return Condition.BAD;
            default:
                throw new IllegalArgumentException("No such condition in the system.");
        }
    }
}
