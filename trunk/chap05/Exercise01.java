/**
 * @author Poorva Singal
 */

/*
 * Exercise 5.1
 * 
 * Write a class method named isDivisible that takes two integers, n and m and
 * returns true if n is divisible by m and false otherwise
 */

public class Exercise01 {
	
	public static boolean isDivisible(int n, int m) {
		if (n%m == 0) { 
			return true;
		}
		return false;
	}
	
}
