/**
 * @author Poorva Singal
 */

/*
 * Exercise 5.6
 * 
 * The purpose of this exercise is to translate a recursive definition into a 
 * Java method.  The Ackerman function is defined for non-negative integers
 * as follows:
 * 
 * A(m,n) = n + 1               if m = 0
 *        = A(m - 1,1)          if m > 0, n = 0
 *        = A(m - 1,A(m,n - 1)) if m > 0, n > 0
 *        
 * Write a method called ack that takes two ints as parameters and that 
 * computes and returns the value of the Ackerman function.
 * 
 * Test your implementation of Ackerman by invoking it from main and 
 * printing the return value.
 * 
 * WARNING: the return value gets very big very quickly.  You should try
 * it only for small values of m and n (not bigger than 2).
 */
public class Exercise06 {

	// Assumes n >= 0, m >= 0
	public static int ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		}
		else if (n == 0) {
			return ack(m - 1, 1);
		}
		else {
			return ack(m - 1, ack(m, n - 1)); 
		}
	}
	
	public static void main(String[] args) {
		System.out.println("A(0, 0) = " + ack(0, 0));
		System.out.println("A(0, 1) = " + ack(0, 1));
		System.out.println("A(1, 0) = " + ack(1, 0));
		System.out.println("A(2, 1) = " + ack(2, 1));
		System.out.println("A(1, 1) = " + ack(1, 1));
		System.out.println("A(2, 2) = " + ack(2, 2));
	}
}
