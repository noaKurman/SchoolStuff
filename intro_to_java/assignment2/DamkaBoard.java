/*
 * Assignment number : 1.2
 * File Name : AddTwo.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class Get two numbers from user and add them

public class DamkaBoard {

	public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 1;
        for (int i=0; i<n; i++) {
            if (count % 2 ==0) {
                System.out.print(" ");
            }
            for (int j=0; j<n-1; j++) {
                System.out.print("*" + " ");

            }
            System.out.println("*");
            count +=1;
        }
    }
}
