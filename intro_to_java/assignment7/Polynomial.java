/*
 * Assignment number : 7
 * File Name : Polynomial.java
 * Name (First Last) : Noa Kurman
 * Student ID : 204404305
 * Email : noa.kurman@post.idc.ac.il
 */
package Polinomials;

import std.StdDraw;

public class Polynomial {
	
	private int[] a;    // The coefficient of x^i is stored in a[i]
	private int degree; // The degree of this polynomial

	/**
	 * Constructs a polynomial from the given array of coefficients.
	 * If the given coefficients include trailing zeros, ignores them.
	 * @param coeffArr The given coefficients. The coefficient of the 
	 *             zero's term is represented by coeffArr[0], and so on.
	 */ 
	public Polynomial(int[] coeffArr) {
		// Computes and sets the degree of this polynomial.
		// If the given coefficients include trailing zeros, ignores them.
		int i = 0;
        this.degree = 0;
        int point = 0;
        int length = coeffArr.length-1;
        
        while ( i == 0 && point <= length) {
            i = coeffArr[length - point];
            point++;
        }
        degree = coeffArr.length - point;
        this.a = new int[degree+1];

        System.arraycopy(coeffArr, 0, this.a, 0, degree+1);
        
	}
	
	/** Returns the degree of this polynomial.
	 *  @return The degree of this polynomial.
	 */
	public int getDegree() {
		return this.degree;
	}
	
	/**
	 * Returns the coefficients of this polynomial.
	 * @return The coefficients of this polynomial, as an int array.
	 */
	public int[] getCoeffArr(){
		// Constructs an array of the right size, copies all the coefficients of this polynomial into it,
		// and returns the array. This is done in order to protect the coefficients of this polynomial. 
		// (If we will simply return the a array, the user can destroy it).
		int [] newarr = new int[this.a.length];
        System.arraycopy(this.a, 0, newarr, 0, this.a.length);
		return newarr;
	}
	
	/**
	 * Returns the i'th coefficient of this polynomial. <br>
	 * If i is greater than the degree of this polynomial, returns 0.
	 * @param i The term's power.
	 * @return The i'th coefficient of this polynomial.
	 */
	public int getCoefficient(int i) {
		int x;
		if (i > this.degree) {
			x = 0;
		}
		else {
			x = this.a[i];
		}
		return x;
	}
	
	/**
	 * Returns the value of this polynomial at the given point.
	 * @param x The value at which this polynomial is computed 
	 * @return The value of this polynomial at the given point.
	 */
	public double value(double x) {
		double sum = 0.0;
		for (int i = this.a.length - 1; i >= 0; i--) {
    	        sum += this.a[i]*Math.pow(x, i); 
        }
		return sum;
	}
	
	/**
	 * Returns a vector of values of this polynomial,
	 * computed over the given vector of values.
	 * @param x The values at which this polynomial is computed 
	 * @return The values of this polynomial at the given points.
	 */
    private double[] value(double x[]) {
    	    double[] newArr = new double [x.length];
    	    for (int i = 0; i < x.length; i++) {
    	    	    newArr[i] = this.value(x[i]);
    	    }
        return newArr;
    }
    
    /**
	 * Returns the multiplication of this polynomial by the given scalar value.
	 * @param c The scalar
	 * @return The multiplication of this polynomial by the given scalar, as a new polynomial
	 */
	public Polynomial multByScalar(int c) {
		int [] newPol = new int[this.a.length];
		for (int i = 0; i < newPol.length; i++) {
			newPol[i] = this.a[i]*c;
		}
		Polynomial pol = new Polynomial(newPol); 		
		return pol;
	}
	
	/**
	 * Returns the polynomial resulting from the addition of this polynomial
	 * and the other polynomial.
	 * @param other The other polynomial which is added to this polynomial.
	 * @return The sum of this polynomial and the other one, as a new polynomial.
	 */
	public Polynomial plus(Polynomial other) {
		int biggerLength = 0; 
		Polynomial old = new Polynomial(this.a);
		if (other.getDegree() > old.getDegree()) {
			biggerLength = other.getDegree()+1;
		}
		else {
			biggerLength = old.getDegree()+1;
		}
		int [] sum = new int [biggerLength];
		for (int i = 0; i < biggerLength; i++) {
			sum[i] = old.getCoefficient(i) + other.getCoefficient(i); 
			
		}
		Polynomial total = new Polynomial(sum);
		return total;
	}
	
	/**
	 * Returns the first derivative of this polynomial.
	 * @return The first derivative of this polynomial, as a new polynomial
	 */
	public Polynomial derivative() {
		int derArr[];
		derArr = new int [this.a.length];
		if (this.a[this.a.length-1] == 0) {
			derArr = new int [this.a.length];
		}
		else {
			derArr = new int [this.a.length-1];
		}
		
		for (int i = 1; i <= derArr.length; i++) {
			derArr[i-1] = this.a[i]*i;
		}
		Polynomial dervativePol = new Polynomial(derArr);
		return dervativePol;
	}
	
	/**
	 * Displays the graph of this polynomial, computed over the given range of values.
	 * @param xMin The left-most x value
	 * @param xMax The right-most x value
	 * @param nSegments The number of line segments used to approximate the graph
	 */
	public void plot(int xMin, int xMax, int nSegments) {
		double x[] = xArr(xMin, xMax, nSegments);
		double[] y = this.value(x);
		StdDraw.setXscale(xMin, xMax);
		StdDraw.setYscale(min(y), max(y)); 
		for (int i = 0; i < nSegments; i++) {
			StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
	     }
	}
	/** Returns a string representation of this polynomial.
	 * @return This polynomial as a string of the form an*x^n + ... + a1*x + a0
	 */
	public String toString() {
		int length = this.a.length; 
		String pol = "";
		for (int i = length - 1; i >= 0; i--) {
			String sign = "+";
			int num = this.a[i];
		    String x = "";
			if (num < 0) { 
		        sign = "-";
		        num = num * (-1);
		    }
			if (i != 0) {
				x = "x^"+i;
			}
			if (i == 1) {
				x = "x";
			}
			if (i == (length - 1) && num == 1 && sign != "-") { 
				pol += x;
			}
			else if (i != 0 && num == 1) {
				pol += sign + x;
			}
			else if (i == (length - 1) && sign != "-" && num != 0) {
			    pol += num + x;
			}
			else if (num != 0) {
			    pol += " " + sign + " " + num + x;
			}
			if (num == 0 && this.a.length == 1) {
				pol += "0";
			}
		}
		
		return pol;
	}
	
    // Returns an array that represent N equally-spaced
    // points between a and b
    private static double[] xArr(double q, double b, int N) {
    	    double[] x = new double[N+1];
    	    double interval = (b - q) / N;
    	    for (int i = 0; i <= N; i++) {
        	    x[i] = q + (i * interval);
    	    }
        return x;
    }
    
    // Returns the minimum value in the given array
    private static double min(double arr[]) {
        double min = 0; 
        for (int i = 0; i < arr.length; i++) {
        	    if (arr[i]<min) {
        	    	    min = arr[i];
        	    }
        }
    	return min;
    }

    // Returns the maximum value in the given array
    private static double max(double arr[]) {
    	double max = 0; 
        for (int i = 0; i < arr.length; i++) {
        	    if (arr[i]>max) {
        	    	    max = arr[i];
        	    }
        }    	
        return max;
    }
}
