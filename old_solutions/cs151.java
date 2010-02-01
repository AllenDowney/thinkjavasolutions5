// cs151.java: this file contains two classes, Complex and cs151.
// Only one class in a file can be public -- the one that contains
// main.

class Complex
{
  double real, imag;

  // simple constructor
  public Complex () {
    this.real = 0.0;  this.imag = 0.0;
  }
	
  // constructor that takes arguments
  public Complex (double real, double imag) {
    this.real = real;  this.imag = imag;
  }

  public static void printComplex (Complex c) {
    System.out.println (c.real + " + " + c.imag + "i");
  }

  // conjugate is a modifier
  public static void conjugate (Complex c) {
    c.imag = -c.imag;
  }

  // abs is a function that returns a primitive
  public static double abs (Complex c) {
    return Math.sqrt (c.real * c.real + c.imag * c.imag);
  }

  // add is a function that returns a new Complex object
  public static Complex add (Complex a, Complex b) {
    return new Complex (a.real + b.real, a.imag + b.imag);
  }
}

public class cs151 {

  public static void main(String args[]) {

    // use the first constructor
    Complex x = new Complex ();
    x.real = 1.0;
    x.imag = 2.0;

    // use the second constructor
    Complex y = new Complex (3.0, 4.0);

    System.out.println (Complex.abs (y));
    
    Complex.conjugate (x);
    Complex.printComplex (x);
    Complex.printComplex (y);
    
    Complex s = Complex.add (x, y);
    Complex.printComplex (s);
  }
}


