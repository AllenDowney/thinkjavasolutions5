/**
 * 
 * @author Poorva Singal
 *
 */

/*
 * Exercise 10.1
 * 
 * Write a method called randomDouble that takes two doubles, low and high,
 * and that returns a random double x so that low <= x < high.
 * 
 */
public class Exercise01 {
	public static double randomDouble(double low, double high) {
		double difference = high - low;
		return Math.random()*difference + low; 
	}
}
