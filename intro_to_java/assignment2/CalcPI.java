/*
 * Assignment number : 1.2
 * File Name : AddTwo.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class Get two numbers from user and add them

public class CalcPI {

	public static void main(String[] args) {
        int prox = Integer.parseInt(args[0]);
        double quarter = 0.0;
        int counter = 1;
        int sign = 1;
        for (int i=0; i<prox; i++) {
            System.out.println(quarter);
            quarter = quarter + sign * (1.0 / counter);
            counter += 2;
            sign = sign*(-1);
        }
        double pi = (quarter*4.0);
        System.out.println(pi);
    }
}
