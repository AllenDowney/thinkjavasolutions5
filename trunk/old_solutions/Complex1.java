public class Complex1
{
  double real, imag;

  public Complex () {
    this.real = 0.0;  this.imag = 0.0;
  }
	
  public Complex (double real, double imag) {
    this.real = real;  this.imag = imag;
  }
	
  public static void printComplex (Complex x) {
    System.out.println (c.real + " + " + c.imag + "i");
  }

  public static void conjugate (Complex c) {
    imag = -c.imag;
  }

  public static double abs (Complex c) {
    return Math.sqrt (c.real * c.real + c.imag * c.imag);
  }
	
  public static Complex add (Complex a, Complex b) {
    return new Complex (a.real + b.real, a.imag + b.imag);
  }
	
  public static Complex mult (Complex a, Complex b) {
    double r = a.real * b.real - a.imag * b.imag;
    double i = a.real * b.imag + a.imag * b.real;
    return new Complex (r, i);
  }

  public void normalize () {
    double d = this.abs();
    real = real/d;
    imag = imag/d;
  }
		
  public static void main(String args[]) {
    Complex x = new Complex ();
    x.real = 1.0;
    x.imag = 2.0;
    Complex y = new Complex (3.0, 4.0);
    
    Complex s = add (x, y);
    System.out.println (s);
    s = x.add (y);
    System.out.println (s);

    Complex p = mult (x, y);
    System.out.println (p);
  }
}


