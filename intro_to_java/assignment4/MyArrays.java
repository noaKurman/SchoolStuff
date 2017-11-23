public class MyArrays {
	
	public static void main(String []args) {
		// Uncomment the tester that you want to run:
		test1();
		test2();
		test3();
		test4();
	}
	
	private static void test1() {
		// Tests the hasDuplicates function.		
		int[] a = {5, 7, 4, 12, 3, 3};
		int[] b = {1, 0, 2, 9};
		System.out.println(hasDuplicates(a)); // returns true
		System.out.println(hasDuplicates(b)); // return false
	}

	private static void test2() {
		// Write a similar tester for the Inorder function.
		int[] a = {2, 0, 12, 4};
		int[] b = {4, 5, 6, 7};
		System.out.println(inOrder(a)); // returns false 
		System.out.println(inOrder(b)); // return true 
	}
	
	private static void test3() {
		// Write a similar tester for the rotate function.
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = rotate(a, 3); // get back array a after being rotated 3 times 
        print(b); //print the given array
	}
	
	private static void test4() {
		// Write a similar tester for the concat function.
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int[] arr3 = concat(a,b); // add the "sum" of the two arrays
        print(arr3); // print the new concated array
	}
	
	/** If the given array contains an element that appears at least twice, returns true.
	 *  Otherwise, returns false. */
	public static boolean hasDuplicates(int[] arr) {
    	    // Replace the following statement with your code.
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        return true;
                    }
                }
            }

    	    return false;
    }
	
	/** If the elements of the given array are in increasing (greater or equal) order, returns true.
	 *  Otherwise, returns false. */
	public static boolean inOrder(int[] arr) {
    	    // Replace the following statement with your code.
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        return false;
                    }
                }
            }
    	    return true;
    }
	
	/** Returns an n-rotation of the given array. Array elements whose indices become too large are wrapped around.
	 * Assumes (without checking) that n is a non-negative number which is less than the array size.
	 * For example, consider the array [1 9 6 5 7]. If n=2, the rotated array will be [5 7 1 9 6].
	 */
	public static int[] rotate(int[] arr, int n) {
		// Replace the following statement with your code.
        for (int i = 0; i < n; i++) {
            int first = arr[0];
            for (int j = 0; j < (arr.length) - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[(arr.length - 1)] = first;
        }
		return arr;
	}
	
	 /** Returns an array whose elements consist of all the elements of arr1, followed by all the elements of arr2. */
    public static int[] concat(int[] arr1, int[] arr2) {
    	    // Replace the following statement with your code.
            int arr3Length = arr1.length + arr2.length;
            int[] arr3 = new int[arr3Length];
            int f = 0; 
            for (int i = 0; i < arr1.length; i++) {
                arr3[i] = arr1[i];
            }
            for (int i = arr1.length; i < arr3Length; i++) {
                arr3[i] = arr2[f];
                f++;
            }
    	    return arr3;
    }

	// Prints the given int array​
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
