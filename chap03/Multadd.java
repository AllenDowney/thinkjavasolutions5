/**
 * @author Poorva Singal
 */

/*
 * Exercise 3.5
 * 
 * Many computations can be expressed concisely using the “multadd” operation, which
 * takes three operands and computes a*b + c. Some processors even provide a hardware
 * implementation of this operation for floating-point numbers.
 * 
 * a. Create a new program called Multadd.java.
 * 
 * b. Write a method called multadd that takes three doubles as parameters and that
 * prints their multadditionization.
 * 
 * c. Write a main method that tests multadd by invoking it with a few simple parameters, 
 * like 1.0, 2.0, 3.0, and then prints the result, which should be 5.0.
 * 
 * d. Also in main, use multadd to compute the following values:
 * sin(pi/4) + cos(pi/4)/2
 * log(10) + log(20)
 * 
 * e. Write a method called yikes that takes a double as a parameter and that uses
 * multadd to calculate and print xe^(-x) + sqrt(1 - e^(-x)) 
 * HINT: the Math method for raising e to a power is Math.exp.
 * 
 * In the last part, you get a chance to write a method that invokes a method you wrote.
 * Whenever you do that, it is a good idea to test the first method carefully before
 * you start working on the second. Otherwise, you might find yourself debugging two
 * methods at the same time, which can be very difficult.
 * One of the purposes of this exercise is to practice pattern-matching: the ability to
 * recognize a specific problem as an instance of a general category of problems.
 */

public class Multadd {
	
	public static void multadd(double a, double b, double c) {
		double result = a*b + c;
		System.out.println (result);
	}
	
	public static void yikes(double x) {
		double a = x;
		double b = Math.exp(-x); 
		double c = Math.sqrt(1.0 - b);
		multadd(a, b, c);
	}

	public static void main(String[] args) {
		
		//Test multadd
		System.out.print ("The multadditionization of 1.0, 2.0, and 3.0 is: ");
		multadd(1.0, 2.0, 3.0);
		System.out.println();
		
		double a1 = Math.cos(Math.PI/4.0);
		double b1 = 1.0/2.0;
		double c1 = Math.sin(Math.PI/4.0);
		System.out.print ("sin(pi/4) + cos(pi/4)/2 = ");
		multadd (a1, b1, c1);
		System.out.println(); 
		
		double a2 = 1.0;
		double b2 = Math.log(10);
		double c2 = Math.log(20);
		System.out.print("log(10) + log(20) = ");
		multadd(a2, b2, c2);		
	}
}
