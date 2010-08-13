/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Excerise 10.4
 * 
 * Write a class method named areFactors that takes an integer n and an array
 * of integers, and that returns true if the numbers in the array are all 
 * factors of n (which is to say that n is divisible by all of them).  HINT: 
 * See exercise 5.1.
 * 
 */
public class Exercise04 {
	public static boolean areFactors(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]%n != 0) {
				return false;
			}
		}
		return true; 
	}
}
