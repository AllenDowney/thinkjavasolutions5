/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Exercise 10.6
 * 
 * Write a method called arrayHist that takes an array of integers and that
 * returns a new histogram array.  The histogram should contain 11 elements
 * with the following contents:
 * 
 * element 0 -- number of elements in the array that are <= 0
 *         1 -- number of elements in the array that are == 1
 *         2 -- number of elements in the array that are == 2
 *         ...
 *         9 -- number of elements in the array that are == 9
 *         10 -- number of elements in the array that are >= 10
 *         
 */
public class Exercise06 {
	public static int[] arrayHist(int[] arr) {
		int[] hist = new int[11];
		
		for(int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (val <= 0) {
				hist[0]++; 
			} else if (val >= 10) {
				hist[10]++;
			} else {
				hist[val]++; 
			}
		}
		return hist;
	}
}
