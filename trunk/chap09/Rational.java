/**
 * Represents a rational number
 * 
 * @author Mikey Lintz
 *
 */
public class Rational {

	int numerator, denominator;

	// simple constructor that sets the numerator
	// and denominator of the rational number to 0
	public Rational() {
		this.numerator = 0;
		this.denominator = 0;
	}

	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public static void printRational(Rational rational) {
		System.out.println(rational.numerator + "/" + rational.denominator);
	}

	// negate is a modifier that reverses the sign of the rational number
	public static void negate(Rational rational) {
		int numerator = rational.numerator;
		int negatedNumerator = -1 * numerator;
		rational.numerator = negatedNumerator;
	}

	// invert is a modifier that swaps the numerator and denominator
	// of the rational number
	public static void invert(Rational rational) {
		int oldNumerator = rational.numerator;
		int oldDenominator = rational.denominator;
		rational.numerator = oldDenominator;
		rational.denominator = oldNumerator;
	}

	// toDouble is a pure function that returns the rational number
	// expressed as a decimal
	public static double toDouble(Rational rational) {
		double numerator = rational.numerator;
		double denominator = rational.denominator;
		return numerator / denominator;
	}

	// returns the gcd of two integers
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		int r = a % b;
		return gcd(b, r);
	}

	// reduce is a modifier that reduces a rational number to its
	// lowest terms
	public static void reduce(Rational rational) {
		int gcd = gcd(rational.numerator, rational.denominator);
		rational.numerator = rational.numerator / gcd;
		rational.denominator = rational.denominator / gcd;
	}

	// returns the sum of the two rational numbers
	public static Rational add(Rational rational1, Rational rational2) {
		int newNumerator = rational1.numerator * rational2.denominator
				+ rational1.denominator * rational2.numerator;
		int newDenominator = rational1.denominator * rational2.denominator;
		Rational newRational = new Rational(newNumerator, newDenominator);
		reduce(newRational);
		return newRational;
	}

	public static void main(String[] args) {
		// Create a new rational number and set it to 2/3
		Rational rational1 = new Rational();
		rational1.numerator = -2;
		rational1.denominator = 3;
		printRational(rational1); // -2/3

		// Create a rational number using the second constructor
		Rational rational2 = new Rational(4, 5);
		printRational(rational2); // 4/5

		// Negate the rational number
		negate(rational1);
		printRational(rational1); // 2/3

		// Invert the numerator and denominator
		invert(rational1);
		printRational(rational1); // 3/2

		// Convert the rational number to a double
		double decimal = toDouble(rational1);
		System.out.println(decimal); // 1.5

		// Reduce a rational number to its lowest terms
		Rational rational3 = new Rational(7, 21);
		printRational(rational3); // 7/21
		reduce(rational3);
		printRational(rational3); // 1/3
		
		// Sum two rationals
		printRational(add(rational2, rational3)); // 17/15
	}

}
