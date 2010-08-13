/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Exercise 10.10
 * 
 * One not-very-efficient way to sort the elements of an array is to find the 
 * largest element and swap it with the first element, then find the 
 * second-largest element and swap it with the second, and so on.
 * 
 * a. Write a method called indexOfMaxInRange that takes an array of integers, 
 *     finds the largest element in the given range, and returns its index. 
 *     You can modify your recursive version of maxInRange or you can write an 
 *     iterative version from scratch.
 *     
 * b. Write a method called swapElement that takes an array of integers and two
 *     indices, and that swaps the elements at the given indices.
 *     
 * c. Write a method called sortArray that takes an array of integers and that 
 *     uses indexOfMaxInRange and swapElement to sort the array from largest to 
 *     smallest.
 */
public class Exercise10 {
	public static int indexOfMaxInRange(int[] arr, int lowIndex, int highIndex) {
		int indexOfMax = lowIndex;
		
		for (int i = lowIndex+1; i <= highIndex; i++) {
			if (arr[i] > arr[indexOfMax]) {
				indexOfMax = i;
			}
		}
		return indexOfMax; 
	}
	
	public static void swapElement(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp; 
	}
	
	public static void sort(int[] arr) {
		int length = arr.length;
		//use length-1 because do not need to swap last element with itself
		for (int i = 0; i < length-1; i++) {
			int indexOfMax = indexOfMaxInRange(arr, i, length-1);
			swapElement(arr, i, indexOfMax); 
		}
	}	
}
