/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Exercise 10.11
 * 
 * Write a method called letterHist that takes a String as a parameter and 
 * that returns a histogram of the letters in the String. The zeroeth element 
 * of the histogram should contain the number of a’s in the String (upper and 
 * lower case); the 25th element should contain the number of z’s. Your 
 * solution should only traverse the String once.
 */
public class Exercise11 {
	public static int[] letterHist(String s) {
		int[] hist = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			char curChar = s.toLowerCase().charAt(i);
			
			//only include letters in histogram
			if ('a' <= curChar && curChar <= 'z') {
				hist[curChar-'a']++;
			}
		}
		
		return hist;
	}
}
