/*
 * Assignment number : 1.3
 * File Name : SinFunction.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */

// This class shows the sinus of PI
public class SinFunction {


	public static void main (String[] args){
		
        	System.out.println("sin(0) = " + Math.sin(0*Math.PI));  
        	System.out.println("sin(1/4) = " + Math.sin(0.25*Math.PI));  
        	System.out.println("sin(1/2) = " + Math.sin(0.50*Math.PI));  
        	System.out.println("sin(3/4) = " + Math.sin(0.75*Math.PI));  
        	System.out.println("sin(PI) = " + Math.sin(1.0*Math.PI));  
        	System.out.println("sin(5/4) = " + Math.sin(1.25*Math.PI));  
        	System.out.println("sin(3/2) = " + Math.sin(1.5*Math.PI));  
        	System.out.println("sin(7/4) = " + Math.sin(1.75*Math.PI));  
        	System.out.println("sin(2 PI) = " + Math.sin(2.0*Math.PI));  
        
        /* Dear bodek, in the following comment i added a part to calculate the sin using a for loop, 
         * i already wrote it and felt bad to throw it away, so its here. 
         */
        
        //for(double i=0.0; i<=2.0; i+=1d/4d){
        //    double sin = Math.sin(i*Math.PI);
        //    if(i > 0){
        //      int firstNum = (int)Math.floor((i*100)/25);
        //      int secondNum = (100 / 25);
        //      System.out.println("sin(" + firstNum + "/" + secondNum + " PI) = " + sin);
        //    }
        //    else{
        //      System.out.println("sin(" + i + ") = " + sin);
        //    }
        //}	
	}	
}
