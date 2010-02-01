public class MathDemo
{

	public static void main(String args[])
	{
		double a = 5.0;
		double b = 3.0;
		double a_tada_b;
		
		// two ways to raise a to the b power
		a_tada_b = Math.pow (a, b);
		System.out.println (a_tada_b);
		
		a_tada_b = Math.exp (Math.log (a) * b);
		System.out.println (a_tada_b);

		// the constant Math.PI is equal to 3.141592653...
		a = Math.sin (Math.PI / 2.0);
		System.out.println (a);
		
		// here's something surprising due to floating-point roundoff
		b = 0.1 - 0.09;
		System.out.println (b - 0.01);		// output is 8.xxxe-18
	}

}


