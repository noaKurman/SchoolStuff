/*
 * Assignment number : 1.3
 * File Name : DamkaBoard.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class will create a damka baord from asstrikes

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
