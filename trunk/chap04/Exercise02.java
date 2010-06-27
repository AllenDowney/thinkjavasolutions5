/**
 * @author Poorva Singal
 */

/*
 * Exercise 4.2
 * 
 * If you are given three sticks, you may or may not be able to arrange
 * them in a triangle. For example, if one of the sticks is 12 inches long and the other
 * two are one inch long, it is clear that you will not be able to get the short sticks to
 * meet in the middle. For any three lengths, there is a simple test to see if it is possible
 * to form a triangle:
 * 
 * “If any of the three lengths is greater than the sum of the other two,
 * then you cannot form a triangle. Otherwise, you can.”
 * 
 * Write a method named isTriangle that it takes three integers as arguments, and that
 * returns either true or false, depending on whether you can or cannot form a triangle
 * from sticks with the given lengths.
 * 
 * The point of this exercise is to use conditional statements to write a method that
 * returns a value.
 */
public class Exercise02 {

	public static boolean isTriangle(int length1, int length2, int length3) {	
		// return false if any side length is greater than the sum of other two sides
		if (length1 > (length2 + length3)) {
			return false;
		} else if (length2 > (length1 + length3)) {
			return false;
		} else if (length3 > (length1 + length2)) {
			return false;
		} else {
			return true;
		}
	}
}
