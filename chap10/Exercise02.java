/**
 * 
 * @author Poorva Singal
 * 
 */

/*
 * Exercise 10.2
 * 
 * Write a method called randomInt that takes two arguments, low and high, and
 * that returns a random integer between low and high (including both).
 * 
 */
public class Exercise02 {
	public static int randomInt(int low, int high) {
		int difference = high - low;
		return (int)(Math.random()*(difference + 1)) + low;
	}
}
