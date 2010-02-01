public class Complex
{
	double real, imag;

	public Complex () { real = 0.0;  imag = 0.0; }
	
	public Complex (double r, double i) { real = r;  imag = i; }
	
	public String toString () { return real + " + " + imag + "i"; }
	
	// conjugate is a modifier: it changes one of the instance variables and returns void
	public void conjugate () { imag = -imag; }
	
	// abs is a unary operator: it returns the absolute value of the current object
	public double norm () { return Math.sqrt (real*real + imag*imag); }
	
	// add is a function that takes two Complex numbers and computes a third Complex
	public static Complex add (Complex a, Complex b)
	{
		// invoke the constructor to create a new object to return
		return new Complex (a.real + b.real, a.imag + b.imag);
	}
	
	// mult is similar to add except that is uses a couple of local variables
	public static Complex mult (Complex a, Complex b)
	{
		// I avoided calling the local variables real and imag, to avoid
		// confusion with the instance variables of the same name
		double r = a.real * b.real - a.imag * b.imag;
		double i = a.real * b.imag + a.imag * b.real;
		return new Complex (r, i);
	}
		
	public static void main(String args[])
	{
		Complex x = new Complex (1.0, 2.0);
		Complex y = new Complex (3.0, 4.0);
		
		Complex s = add (x, y);
		Complex p = mult (x, y);
		
		System.out.println (s);     // prints 4 + 6i
		System.out.println (p);     // prints -5 + 10i
		System.out.println (x);     // prints 1 + 2i
		System.out.println (y);     // prints 3 + 4i
	}
}


