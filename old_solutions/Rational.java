public class Rational {
  int num, den;

  // default constructor

  public Rational () {
    this.num = 0;  this.den = 0;
  }

  // constructor with arguments

  public Rational (int num, int den) {
    this.num = num;  this.den = den;
  }

  // printRational: prints the contents of the object in
  // a simple format
  public static void printRational (Rational r) {
    System.out.println (r.num + "/" +  r.den);
  }

  // negate is a modifier
  public static void negate (Rational r) {
    r.num = -r.num;
  }

  // invert is a modifier.  Notice that we have to use a temp
  // variable to swap things.

  public static void invert (Rational r) {
    int temp = r.num;
    r.num = r.den;
    r.den = temp;
  }

  // toDouble is a pure function that returns a primitive

  public static double toDouble (Rational r) {
    return (double) r.num / r.den;
  }

  // reduce is a modifier

  public static void reduce (Rational r) {
    int gcd = commonDivisor (r.num, r.den);
    r.num /= gcd;
    r.den /= gcd;
  }

  // commonDivisor: this method works on integers rather than
  // Rational objects, since this way it is a bit more general

  public static int commonDivisor (int a, int b) {
    if (b == 0) return a;
    return commonDivisor (b, a%b);
  }

  // add is a pure function that returns a newly-created
  // Rational object

  public static Rational add (Rational r1, Rational r2) {
    Rational sum = new Rational ();
    sum.den = r1.den * r2.den;
    sum.num = r1.num * r2.den + r2.num * r1.den;
    reduce (sum);
    return sum;
  }

  public static void main (String[] args) {
    Rational rat1 = new Rational ();
    rat1.num = 6;
    rat1.den = 8;

    Rational rat2 = new Rational (5, 6);

    printRational (rat1);
    printRational (rat2);

    negate (rat1);
    printRational (rat1);

    invert (rat2);
    printRational (rat2);
    
    Rational result = add (rat1, rat2);
    printRational (result);
  }
}
