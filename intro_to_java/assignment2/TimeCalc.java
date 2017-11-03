/*
 * Assignment number : 1.2
 * File Name : AddTwo.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class Get two numbers from user and add them

public class TimeCalc {

	public static void main(String[] args) {
            String timestamp = args[0];
            int m = Integer.parseInt(args[1]);
            String AP = "AM";
            String stringTimeHours = (timestamp.charAt(2) + timestamp.charAt(3));
            String stringTimeMinutes = (timestamp.charAt(2) + timestamp.charAt(3));
            int timeHours = Integer.parseInt(stringTimeHours) - '0';
            int timeMinutes = Integer.parseInt(stringTimeMinutes) - '0';
            if (timeHours > 24 || timeHours <= 0) { 
                System.out.println("Oh no! this is an invalid input! Enter a valid hours");
                System.exit(0);
            }
            else {
                if (timeMinutes >= 60 || timeMinutes < 0) {
                    System.out.println("Oh no! this is an invalid input! Enter valid minutes");
                    System.exit(0);
                }
            }
            int hoursElasped = 0;
            int minutesElapsed = 0; 
            int currentHours = 0;
            int currentMinutes = 0;
            if ( m >= 60 ) { 
                hoursElasped = m / 60;
                minutesElapsed = m % 60; 
                currentHours = timeHours + hoursElasped;
                currentMinutes = timeMinutes + minutesElapsed; 
            }
            while ( currentHours >= 24 ) {
                currentHours = currentHours - 24;
            }

            while ( currentHours > 12 ) {
                currentHours = currentHours - 12;
                AP = "PM";
            }
            if ( currentHours == 0 && AP == "AM" ) { 
                currentHours = 0;
                currentMinutes = 00;
            }
            String minutes = String.format("%02d", currentMinutes);
            System.out.printf(currentHours + ":" + minutes + AP + "%n");
    }
}
