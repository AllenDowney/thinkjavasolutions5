/**
 * @author Poorva Singal
 */

/*
 * Exercise 6.6
 * 
 * One way to calculate e^x is to use the infinite series expansion
 *     e^x = 1 + x + x^2/2! + x^3/3! + x^4/4! + ...
 * 
 * If the loop variable is named i, then the ith term is equal to x^i/i!
 * 
 * a. Write a method named myexp that adds up the first n terms of the series
 *     shown above.  You can use the factorial method from Section 5.10 or your
 *     interative version.
 *     
 * b. You can make this method much more efficient if you realize that in each
 *     iteration the numerator of the term is the same as its predecessor 
 *     multiplied by x and the denominator is the same as its predecessor 
 *     multiplied by i.  Use this observation to eliminate the user of Math.pow
 *     and factorial, and check that you still get the same result.
 *     
 * c. Write a method called check that takes a single parameter, x, and that 
 *     prints the values of x, Math.exp(x) and myexp(x) for various values of x.
 *     The output should look something like: 
 *     1.0       2.708333333333333       2.718281828459045
 *     HINT: you can use the String "\t" to print a tab character between
 *     columns of a table.  
 *     
 * d. Vary the number of terms in the series (the second argument that check
 *     sends to myexp) and see the effect of the accuracy n the result. Adjust
 *     this value until the estimated value agrees with the "correct" answer 
 *     when x is 1.
 *     
 * e. Write a loop in main that invokes check with the values 0.1, 1.0, 10.0 
 *     and 100.0.  How does the accuracy of the result vary as x varies? 
 *     Compare the number of digits of agreement rather than the difference 
 *     between the actual and estimated values.
 *     
 * f. Add a loop in main that checks myexp with the values -0.1, -1.0, -10.0, 
 *     and -100.0.  Comment on the accuracy. 
 *     
 */
public class Exercise06 {
	
	
	public static double myexp(double x, int n) {
		double result = 1.0; 
		double term  = 1.0;
		int i = 1;
		while (i <= n) { 
			term = term*x/i; 
			result = result + term;
			i = i+1;
		}
		
		return result; 
	}
	
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
	public static void check(double x) {
		System.out.println(x + "\t" + Math.exp(x) + "\t" + myexp(x, 17)); 
	}
	
	public static void main(String[] args) {
		// The accuracy of the result gets worse as the absolute value of x 
		//     gets larger.  
		
		double x = 0.1;
		while (x <= 100.0) {
			check(x); 
			x = x*10; 
		}
		
		x = -0.1;
		while (x >= -100.0) {
			check(x); 
			x = x*10; 
		}		
	}
}
