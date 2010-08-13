/**
 * @author Poorva Singal
 */

/* 
 * Exercise 6.7
 * 
 * One way to evaluate e^(-x^2) is to use the infinite series expansion
 *     e^(-x^2) = 1 - 2x + 3x^2/2! - 4x^3/3! + 5x^4/4! - ...
 *     
 * In other words, we need to add up a series of terms where the ith term
 * is equal to ((-1)^i)(i+1)x^i/i!.  Write a method named gauss that takes x
 * and n as arguments and that returns the sum of the first n terms of the 
 * series.  You should not use factorial or pow. 
 *  
 */
public class Exercise07 {
	public static double gauss(double x, int n) {
		double result = 1.0;
		double term = 1.0; 
		
		int i = 1;
		while (i <= n) {
			term = -1*term*x*x/i;
			result = result + term; 
			i = i + 1; 
		}
		
		return result;
	}
}
