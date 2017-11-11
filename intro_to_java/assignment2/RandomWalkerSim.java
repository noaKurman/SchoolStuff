/*
 * Assignment number : 1.4
 * File Name : RandomWalkerSim.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

public class RandomWalkerSim {

	public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double averageSquare = 0;
        for (int j=0; j<T; j++) {
            int right=0;
            int left=0;
            for (int i=0; i<n; i++) {
                int side = (int) Math.round(Math.random());   
                if (side == 0) {
                    right = (int) (Math.random()*3)-1+right;
                }
                else { 
                    left = (int) (Math.random()*3)-1+left;
                }
            }
            double total = Math.abs(right) + Math.abs(left);
            double square = (int) Math.pow(total, 2);
            averageSquare = averageSquare + square;
        }
        averageSquare = averageSquare / T;
        System.out.println("After " + T + " trials, the average squared distance of a robot that makes " + n + " random steps is " + averageSquare);
    }
}
