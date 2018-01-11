/*
 * Assignment number : 4.2
 * File Name : VectorSimilarity.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
public class VectorSimilarity {

	public static void main(String []args) {
		// Uncomment the tester that you want to run:
		// test1();
		// test2();
		 //test3();
		// test4();
		 test5(args[0],args[1]);	
	}
	
	private static void test1() {
		// Tests the norm function.
		int[] a = {3, 4};
		int[] b = {2, 0, 5, 0, 0, 3};
		System.out.println(norm(a));
		System.out.println(norm(b));
	}
	
	private static void test2() {
		// Write a similar tester to test the inner product function
		int[] a = {1, 2};
		int[] b = {3, 4};
		int[] c = {1, 2, 3};
		System.out.println(innerProduct(a,b));
		System.out.println(innerProduct(a,c));
	}
	
	private static void test3() {
		// Write a similar tester to test the similarity function.
		int[] a = {1, 2};
		int[] b = {1, 2};
		int[] c = {1, 2, 3};
		System.out.println(similarity(a,b));
		System.out.println(similarity(a,c));
	}
	
	private static void test4() {
		// Tests the strToArray parsing function. Does not test extreme or 
		// invalid values, since in this program we assume that the inputs are valid.
		MyArrays.print(strToArray("4,3,5"));        // Should print 4 3 5
		MyArrays.print(strToArray("7"));            // Should print 7
		MyArrays.print(strToArray("4,0,0,3,0,5"));  // Should print 4 0 0 3 0 5
	}
	
	private static void test5(String inputStr1, String inputStr2) {
		// Test the full program, using two command line arguments.
		int[] arr1 = strToArray(inputStr1);
		int[] arr2 = strToArray(inputStr2);
		System.out.println(similarity(arr1, arr2));	
	}
	
	/** Returns the norm of the vector represented by the given array.
	The norm of a vector (a1, a2, ..., an) is defined as the square root of (a1^2 + a2^2 + ... + an^2). */
	public static double norm(int []a) {
		// Replace the following statement with your code
        int sum = 0;
        for (int i = 0; i < a.length; i++ ) {
            sum = sum + (a[i] * a[i]);
        }
        double norm = Math.sqrt(sum);
		return norm;
	}
	
	/** Returns the inner product of the two vectors represented by the two given arrays.
	 * If the two arrays don't have the same length, returns -1.
	 * The inner product of two vectors (a1, a2, ..., an) and (b1, b2, ..., bn) is defined
	 * as a1*b1 + a2*b2 + ... + an*bn. */
	public static int innerProduct(int []a, int []b) {
		// Replace the following statement with your code
        int schum = 0;
        int sum = 0;
		if (a.length != b.length) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            schum = (a[i] * b[i]);
            sum = sum + schum;
        }
        return sum;
	}
	
	/** Returns the similarity of the two vectors represented by the two given arrays.
	 * The similarity is defined as the inner product of the two vectors, divided by
	 * the multiplication of their norms. If the two arrays don't have the same length, returns -1. */
	public static double similarity(int []a, int []b) {
		// Replace the following statement with your code
		if (a.length != b.length) {
            return -1;
        }
        int inner = innerProduct(a,b);
        double norm = (norm(a) * norm(b));
        double ans = inner/norm;
		return ans;
	}
	
	// Given a comma-separated string of the form "a1,a2,a3,...", returns the array of integers
	// (a1,a2,a3,...). Assumes (without checking) that each character ai in the given string is a single digit. 
	public static int[] strToArray(String str) {
		// Replace the following statement with your code
        int arrLength = (int) Math.floor(str.length() / 2) + 1;
        int[] arr = new int[arrLength];
        int f = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                int number = (int) str.charAt(i)-'0';
                arr[f] = number;
                f++;
            }
        }
		return arr;
	}		
}
