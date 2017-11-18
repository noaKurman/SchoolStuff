/*
 * Assignment number : 3.1
 * File Name : CalcExp.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
public class CalcExp {
    public static void main(String args[]) {
    // Tests the exp function.
      double x = 2;  // use other values, if you want
      int N = 10;    // experiment with other values, to see how it effects the compuatation's accuracy.
      System.out.println("e raised to the power of " + x + " according to Java: "+ Math.exp(x));
      System.out.println("Same value, using my exp function with " + N + " steps: " + exp(x,N));
    }
    

    // Returns an approximation of the value of the constant e raised to the power of the given x.
    // The approximation's accuracy is determined by the given N. The higher N, the higher the accuracy.
    public static double exp(double x, int N) {
        // Replace the following statement with your code:
        double ans = 1.0 + x;
        double powX = x;
        int factorial = 1;
        for (int i = 2; i <= N; i++) { 
            factorial = factorial * i;  
            powX = powX * x;
            ans = ans + (powX / factorial);
        }
        return ans;
    
    }
                    
}
                 
