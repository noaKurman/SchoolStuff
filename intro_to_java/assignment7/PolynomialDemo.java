/*
 * Assignment number : 7
 * File Name : PolynomialDemo.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
package Polinomials;


public class PolynomialDemo {

	public static void main(String args[]) {
        
		// Create an empty polynomial (only 0) and print it
		testPol();
        
		// Test multiply by scalar 2
		testMultiplyBy();
		
		// Test the get coefArr function 
		testGetCoefArr();
		
		// Test the get value function
		testValue();
		
		// Tests the constructor and the toString method.
		test1();

		// Test the Plus function
		testPlus();
		
		// Test the derivative function 
		testDerivative();
		
		// A general test that creates and manipulates some polynomials.
		 generalTest();
	}
	public static void testPol() {	
		// Test polynomial 0 and its degree
		// Should return Pol that contains only 0, and degree 0
		int[] p1CoeffArr = {0};		
		Polynomial p1 = new Polynomial(p1CoeffArr); 
		System.out.println("First Polynomial test: " + p1);
		System.out.println("First GetDegree test: " + p1.getDegree() + "\n");
		
		int[] p1CoeffArr1 = {1, 2, 3};		
		Polynomial p2 = new Polynomial(p1CoeffArr1); 
		System.out.println("Second Polynomial test: " + p2);
		System.out.println("Second GetDegree test: " + p2.getDegree() + "\n");

	}
	public static void testGetCoefArr() {	
		// Get the "array" of the polynomial. 
		// Should get the items in the array separated by commas
		int[] p1CoeffArr = {0, 1, 3};		
		Polynomial p1 = new Polynomial(p1CoeffArr); 
		int[] p2 = p1.getCoeffArr();
		System.out.print("Test the getcofArr: ");
		for (int i = 0; i <= p1.getDegree(); i++) {
			System.out.print(p2[i] + " ");
		}
		System.out.println("\n");

	}
	public static void testMultiplyBy() {	
		// Multiply the polynomial by 2 and place it in a second polynomial
		// Print both polynomials for comparison 
		int[] p1CoeffArr = {0, 1, 3};		
		Polynomial p1 = new Polynomial(p1CoeffArr); 
		Polynomial p2 = p1.multByScalar(2);
		System.out.println("Polynomial without scalaar: " + p1);
		System.out.println("Test multiply by scalar 2: " + p2 + "\n");

	}
	public static void testValue() {	
		// Get the answer of the polynomial if x was 1 (in double) 
		int[] p1CoeffArr = {0, 1, 3};		
		Polynomial p1 = new Polynomial(p1CoeffArr); 
		System.out.println("Value test: " + p1.value(1) + "\n");

	}
	public static void testPlus() {	
		// Test the plus function
		// Add two array that are from different degrees and one of degree 0
		int[] pNoaCoeffArr = {1, -5, 3, 5};
		int[] pNoaCoeffArr2 = {1, 1, 2};
		int[] pNoaCoeffArr0 = {0};

		Polynomial pNoa = new Polynomial(pNoaCoeffArr); 
		Polynomial pNoa2 = new Polynomial(pNoaCoeffArr2);
		Polynomial pNoa0 = new Polynomial(pNoaCoeffArr0); 

		Polynomial NoaPlus = pNoa.plus(pNoa2); 
		Polynomial NoaPlus0 = pNoa.plus(pNoa0); 

		System.out.println("Plus Test: " + NoaPlus);
		System.out.println("Now add just 0: " + NoaPlus0 + "\n");

	}

	public static void testDerivative() {
		// Test the derivative function
		int[] pNoaCoeffArr = {1, -5, 3};		
		int[] pNoaCoeffArr2 = {0, 5, 3};		
		Polynomial pNoa = new Polynomial(pNoaCoeffArr); 
		Polynomial pNoa2 = new Polynomial(pNoaCoeffArr2); 

		Polynomial pNoaDer = pNoa.derivative();
		Polynomial pNoaDer2 = pNoa2.derivative(); 

		System.out.println("Derivative test: " + pNoaDer);
		System.out.println("Derivative test 2: " + pNoaDer2 + "\n");

	}
	
	public static void test1() {	
		// A polynomial of degree = 2
		int[] p1CoeffArr = {1, -5, 3};		
		Polynomial p1 = new Polynomial(p1CoeffArr); 
		System.out.println("Polynomial test: " + p1 + "\n");
		
		// S polynomial of degree = 1 
		int[] p6CoeffArr = {0, 5, -3};		
		Polynomial p6 = new Polynomial(p6CoeffArr); 
		System.out.println("Polynomial test: " + p6 + "\n");
		
		// A polynomial of degree = 4
		int[] p2CoeffArr = {-2, 0, 7, 5, 12};		
		Polynomial p2 = new Polynomial(p2CoeffArr); 
		System.out.println("Polynomial test: " + p2 + "\n");
		
		// A polynomial of degree = 0
		int[] p3CoeffArr = {3};		
		Polynomial p3 = new Polynomial(p3CoeffArr); 
		System.out.println("Polynomial test: " + p3 + "\n");
		
		// A polynomial of degree = 0, with trailing zero coefficients
		int[] p4CoeffArr = {5, 0, 0};		
		Polynomial p4 = new Polynomial(p4CoeffArr); 
		System.out.println("Polynomial test: " + p4 + "\n");
		
		// A polynomial of degree = 0, with trailing zero coefficients
		int[] p5CoeffArr = {0, 0, 0};		
		Polynomial p5 = new Polynomial(p5CoeffArr); 
		System.out.println("Polynomial test: " + p5 + "\n");
	}
	
	public static void generalTest() {
		// p(x) = 3x^2 - 5x + 1
		int[] pCoefficients = {1, -5, 3};		
		Polynomial p = new Polynomial(pCoefficients); 
		System.out.println("p(x) = " + p);
		System.out.println("p(2) = " + p.value(2) + "\n");

		Polynomial ptag = p.derivative(); 
		System.out.println("ptag(x) = " + ptag);
		System.out.println("ptag(2) = " + ptag.value(2)+ "\n");
		
		//  q(x) = x^4 + 2x - 7
		Polynomial q = new Polynomial(new int[] {-7, 2, 0, 0, 1}); 
		System.out.println("q(x) = " + q);
		System.out.println("pPlusq(x) = " + p.plus(q));
		
		// Plots the two functions
		p.plot(-10, 10, 100);
		ptag.plot(-10, 10, 100);
	}
}