/*
 * Assignment number : 1.4
 * File Name : GenThree.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class generates three numbers in a range, get the lowest

public class GenThree {

	public static void main(String[] args) {
        	int min = Integer.parseInt(args[0]);
        	int max = Integer.parseInt(args[1]);
        
        	// Define random and generate three numbers in the range
        	int firstRandom = (int) (Math.random()*(max - min)) + min;
        	int secondRandom = (int) (Math.random()*(max - min)) + min;
        	int thirdRandom = (int) (Math.random()*(max - min)) + min;
        
        	// Get the lowest number, first compare two first numbers and then the lowest vs. the third
        	int lowest = Math.min(firstRandom, secondRandom);
        	lowest = Math.min(lowest, thirdRandom);
        
        	// Print all the generated numbers in different line, as in the example 
        	System.out.println(firstRandom);
        	System.out.println(secondRandom);
        	System.out.println(thirdRandom);
        	System.out.println("The minimal generated number was " + lowest);
	}

}
