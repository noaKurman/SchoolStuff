/*
 * Assignment number : 4.2
 * File Name : Algebra.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
// Represents numbers and algebraic operations as functions.
// Based on two building blocks: the constant 0, and the successor function s(x) = x + 1.
public class Algebra {
	public static void main(String args[]) {
	      // Tests the plus and times functions
 		  System.out.println(plus(two(),three())); // 2 + 3
 		  System.out.println(times(three(),four())); // 3 * 4
   		  System.out.println(plus(two(),times(four(),two()))); // 2 + 4 * 2
	   }  

	   // Returns the sum of the two given integers.
	   public static int plus(int x1, int x2) {
		   // Replace the following statement with your code:
           for (int i = 0; i < x2; i = s(i)) {
               x1 = s(x1);
           }
	       return x1;
	   }

	   // Returns the product of the two given integers.
	   public static int times(int x1, int x2) {
		   // Replace the following statement with your code:
           int counter = x1;
           for (int i = 1; i < x2; i = s(i)) { 
               for(int j = 0; j < x1; j = s(j)) {
                   counter = s(counter);
               }
           }
	       return counter;
	   }	   
	   
	   // Defines the numbers one, two, three and four, for testing purposes.
	   public static int one() {
		   return s(0);
	   }
	   
	   public static int two() {
		   return s(one());
	   }
	   
	   public static int three() {
		   return s(two());
	   }

	   public static int four() {
		   return s(three());
	   }
	   
	   // Returns the successor of the given integer, s(x) = x + 1.
	   public static int s(int x) {
	       return x + 1;
	   }
}

