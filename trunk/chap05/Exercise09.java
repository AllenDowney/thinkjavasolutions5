/**
 * @author Poorva Singal
 */

/*
 * Exercise 5.09
 * 
 * Write a recursive method called power that takes a double x and an integer
 * n and that returns x^n.  Hint: a recursive definition of this operation is
 * power (x,n) = x * power(x, n-1).  Also, remember that anything raised to the
 * zeroeth power is 1.
 */
public class Exercise09 {
	public static double power(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		else if (n > 0) {
			return x*power(x, n - 1);
		}
		else {
			return 1.0/x * power(1.0/x, -n - 1); 
		}
	}

}
