/**
 * @author Poorva Singal
 */

/*
 * Exercise 5.3
 * 
 * The distance between two points (x1, y1) and (x2, y2) is
 * 		Distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
 * 
 * Please write a method named distance that takes four doubles as parameters -
 * x1, y1, x2, y2 - and prints the distance between the points.
 * 
 * You should assume that there is a method named sumSquares that calculates and
 * returns the sum of the squares of its arguments.  For example:
 * 		double x = sumSquares (3.0, 4.0);
 * would assign the value 25.0 to x.
 * 
 * The point of this exercise is to write a new method that uses an existing one.  
 * You should write only one method: distance.  You should not write sumSquares 
 * or main and you should not invoke distance.
 */


public class Exercise03 {
	
	public static double distance(double x1, double y1, double x2, double y2) {
		double sum = sumSquares(x2-x1, y2-y1);
		return Math.sqrt(sum);
	}
	
}
