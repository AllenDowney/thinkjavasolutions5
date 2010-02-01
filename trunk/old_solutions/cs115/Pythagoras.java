public class Pythagoras
{
	// Notice that there are now TWO method definitions in the class Pythagoras
	// The indentation helps make it clear where one ends and the other begins.


	// MAIN: as always, execution begins in main
	public static void main(String args[])
	{
		// you can print the return value from a method
		System.out.println(pythagoras (3.0, 4.0));
		
		// you can pass any expression as an argument, as long as it
		// has the right type.  Then you can do whatever you want with
		// the return value.
		double s1 = 3.0;
		double x = pythagoras (s1, s1 + 1.0) + 17.0;
		System.out.println (x);
		
		// but you can't access other people's local variables
		System.out.println (c_squared);    // ERROR!!!
	}


	// PYTHAGORAS: takes two arguments, both type double, and calculates the
	// third side of the right triangle.  Returns a double.
	
	// don't forget the word static!
	public static double pythagoras (double a, double b)
	{
		// c_squared is a local variable -- it cannot be accessed from main
		double c_squared = a*a + b*b;
		
		// return specifies what the return value will be.  You can return any
		// expression, as long as it has the right type (double in this case)
		return Math.sqrt (c_squared);
	}
}


