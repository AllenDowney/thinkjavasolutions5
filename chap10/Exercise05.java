/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Exercise 10.5
 * 
 * Write a method that takes an array of integers and an integer named target
 * as arguments, and that returns the first index where target appears in the
 * array, if it does, and -1 otherwise.
 * 
 */
public class Exercise05 {
	
	public static int find(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
