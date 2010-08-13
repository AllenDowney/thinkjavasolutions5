/**
 * 
 * @author Poorva Singal
 *
 */
/*
 * Exercise 10.3
 * 
 *     int[] counts = new int[100];
 *     
 *     for (int i = 0; i < scores.length; i++) {
 *         int index = scores[i];
 *         counts[index]++;
 *      }
 * 
 * Encapsulate this code in a method called scoreHist that takes an array
 * of scores and returns a histogram of the values in the array.
 * 
 * Modify the method so that the histogram has only 10 counters, and count
 * the number of scores in each range of 10 values; that is, the 90s, the 90s,
 * etc.
 * 
 */
public class Exercise03 {
	
	public static int[] scoreHist(int[] scores) {
		int[] counts = new int[10];
		
		for (int i = 0; i < scores.length; i++) {
			int index = scores[i];
			
			// including only scores less than 100
			if (index < 100) {
				counts[index/10]++;
			}
		}
		return counts; 
	}
}
