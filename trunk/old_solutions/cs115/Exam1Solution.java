public class Exam1Solution
{
	public static void main(String args[])
	{
		System.out.println(median (7.0, 3.0, 5.0));
		System.out.println(trianglable (3, 5, 12));
	}
	
	// trianglable: takes three integers representing the lengths of the sides
	// of a triangle.  Returns true if it is possible to form a triangle with these
	// sides, false it it is not.
	public static boolean trianglable (int x, int y, int z)
	{
		// if any of the three sides is greater than the sum of the other two,
		// it is impossible to make a triangle
		if (x > y+z) return false;
		if (y > x+z) return false;
		if (z > x+y) return false;
		
		// if none of the tests failed, it must be ok
		return true;
	}
	
	// median: takes three doubles and returns the middlest one
	public static double median (double x, double y, double z)
	{
		// there are two ways x can be the median (z high or y high)
		if ((x > y && x < z) || (x < y && x > z)) return x;
		
		// and two ways y can be the median (x high or z high)
		if ((y > x && y < z) || (y > z && y < x)) return y;
		
		// if we get here, there is only one possiblity left
		return z;
	}
}


