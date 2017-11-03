/*
 * Assignment number : 1.4
 * File Name : RandomWalker.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class is giving the walker a random steps to take

public class RandomWalker {

	public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int right=0;
        int left=0;
        for (int i=0; i<n; i++) {
            int side = (int) Math.round(Math.random());   
            if (side == 0) {
                right = (int) (Math.random()*3)-1+right;
                System.out.println("(" + right + "," + left + ")");
            }
            else { 
                left = (int) Math.random()*3-1+left;
                System.out.println("(" + right + "," + left + ")");
            }
        }
        int total = Math.abs(right) + Math.abs(left);
        int square = (int) Math.pow(total, 2);
        System.out.println("squared distance = " + square);
    }
}
