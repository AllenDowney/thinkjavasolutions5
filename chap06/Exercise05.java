/**
 * @author: Poorva Singal
 */

/* 
 * Exercise 6.5
 * 
 * Section 5.10 presents a recursive method that computes the factorial 
 * function.  Write an interative version of factorial.
 */
public class Exercise05 {
	public static int factorial(int n) {
		int result = 1; 
		while (n > 0) {
			result = result*(n);
			n = n - 1;
		}
		return result; 
	}
}
