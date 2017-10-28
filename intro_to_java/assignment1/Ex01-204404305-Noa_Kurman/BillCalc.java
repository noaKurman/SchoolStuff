/*
 * Assignment number : 1.1
 * File Name : BillCalc.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

/* This class get the amount of a total bill, and number of guests,
 * add 15% tip and return the amount each guest should pay
 */

public class BillCalc {

	public static void main(String[] args){

            int amountToPay = Integer.parseInt(args[0]);
            int numberOfGuests = Integer.parseInt(args[1]);
            int amountWithTip = amountToPay + ((15 * amountToPay) / 100);
            int amountForGuest = amountWithTip / numberOfGuests;
            System.out.println("Each guest should pay " + amountForGuest + " Shekels");

    }
}
