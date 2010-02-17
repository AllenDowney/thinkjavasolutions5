/**
 * @author Mikey Lintz
 */
public class Exercise03 {

	// Calculates the square root of "a"
	// using iterative approximations
	public static double squareRoot(double a) {
		double x0 = 0; // Initial value for x0. Will be overridden in first iteration.
		double x1 = a/2; // Initial guess for the square root of "a."
		while (Math.abs(x1 - x0) > 0.0001) {
			x0 = x1;
			x1 = (x0 + a/x0)/2;
		}
		return x1;
	}
	
	public static void main(String[] args) {
		System.out.println(squareRoot(36)); // approximately 6
		System.out.println(squareRoot(81)); // approximately 9
	}

}
