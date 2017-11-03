/*
 * Assignment number : 1.1
 * File Name : TimeCalc.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class Get a timestamp and a time value in minutes and calculates the sum in time

public class TimeCalc {

	public static void main(String[] args) {
            // Define all the vars
            String timestamp = args[0];
            int m = Integer.parseInt(args[1]);
            String AP = "AM";
            String stringTimeHours = ("" + timestamp.charAt(0) + timestamp.charAt(1));
            String stringTimeMinutes = ("" + timestamp.charAt(3) + timestamp.charAt(4));
            int timeHours = Integer.parseInt(stringTimeHours);
            int timeMinutes = Integer.parseInt(stringTimeMinutes);
            int hoursElasped = 0;
            int minutesElapsed = 0; 
            int currentHours = 0;
            int currentMinutes = 0;
            if (timeHours > 24 || timeHours <= 0) { 
                System.out.println("Invalid input");
                System.exit(0);
            }
            else {
                if (timeMinutes >= 60 || timeMinutes < 0) {
                    System.out.println("Invalid input");
                    System.exit(0);
                }
            }
            if ( m >= 60 ) { 
                hoursElasped = m / 60;
                minutesElapsed = m % 60; 
                currentHours = timeHours + hoursElasped;
                currentMinutes = timeMinutes + minutesElapsed; 
            }
            while ( currentHours >= 24 ) {
                currentHours = currentHours - 24;
            }
            if ( currentHours > 12 ) {
                currentHours = currentHours - 12;
                AP = "PM";
            }
            else if ( currentHours == 0 && AP == "AM" ) { 
                currentHours = 0;
                currentMinutes = 00;
            }
            else if (currentHours == 12 ) {
                AP = "PM";
            }
            String minutes = String.format("%02d", currentMinutes);
            System.out.printf(currentHours + ":" + minutes + AP + "%n");
    }
}
