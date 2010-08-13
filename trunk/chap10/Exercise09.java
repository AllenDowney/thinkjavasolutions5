/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Exercise 10.9
 * 
 * Many of the patterns we have seen for traversing arrays can also be 
 * written recursively. It is not common to do so, but it is a useful exercise.
 * 
 * a. Write a method called maxInRange that takes an array of integers and a 
 *     range of indices (lowIndex and highIndex), and that finds the maximum 
 *     value in the array, considering only the elements between lowIndex and 
 *     highIndex, including both ends.
 *     This method should be recursive. If the length of the range is 1, that 
 *     is, if lowIndex == highIndex, we know immediately that the sole element 
 *     in the range must be the maximum. So that’s the base case.
 *     If there is more than one element in the range, we can break the array 
 *     into two pieces, find the maximum in each of the pieces, and then find 
 *     the maximum of each of the piece-maxima. 
 *     
 * b. Methods like maxInRange can be awkward to use. To find the largest 
 *     element in an array, we have to provide a range that includes the 
 *     entire array.
 *         double max = maxInRange (array, 0, a.length-1);
 *     Write a method called max that takes an array as a parameter and that 
 *     uses maxInRange to find and return the largest value. Methods like max 
 *     are sometimes called wrapper methods because they provide a layer of 
 *     abstraction around an awkward method and provide an interface to the 
 *     outside world that is easier to use. The method that actually performs 
 *     the computation is called the helper method. We will see this pattern 
 *     again in Section 14.9.
 *     
 * c. Write a recursive version of find using the wrapper-helper pattern. find 
 *     should take an array of integers and a target integer. It should return 
 *     the index of the first location where the target integer appears in the 
 *     array, or -1 if it does not appear.
 *     
 */
public class Exercise09 {
	
	public static int maxInRange(int[] arr, int lowIndex, int highIndex) {
		if (lowIndex == highIndex) {
			return arr[lowIndex];
		}
		int midIndex = (lowIndex + highIndex)/2;
		
		int val1 = maxInRange(arr, lowIndex, midIndex);
		int val2 = maxInRange(arr, midIndex+1, highIndex);
		
		if (val1 > val2) {
			return val1;
		} else {
			return val2; 
		} 
	}
	
	public static int max(int[] arr) {
		return maxInRange(arr, 0, arr.length-1); 
	}
	
	public static int findInRange(int[] arr, int target, int lowIndex, int highIndex) {
		if (lowIndex == highIndex) {
			if (arr[lowIndex] == target) {
				return lowIndex;
			}
			else {
				return -1; 
			}
		}
		
		int midIndex = (lowIndex + highIndex)/2;
		int val1 = findInRange(arr, target, lowIndex, midIndex);
		if (val1 >= 0) {
			return val1;
		} 
		return findInRange(arr, target, midIndex + 1, highIndex);
	}
	
	public static int find(int[] arr, int target) {
		return findInRange(arr, target, 0, arr.length-1); 
	}
}
