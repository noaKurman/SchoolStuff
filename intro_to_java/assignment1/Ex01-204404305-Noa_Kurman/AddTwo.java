/*
 * Assignment number : 1.2
 * File Name : AddTwo.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class Get two numbers from user and add them

public class AddTwo {

	public static void main(String[] args) {

            int firstNumber = Integer.parseInt(args[0]);
            int secondNumber = Integer.parseInt(args[1]);
            int solution = firstNumber + secondNumber;
            System.out.println(firstNumber + " + " + secondNumber + " = " + solution);

	}

}
