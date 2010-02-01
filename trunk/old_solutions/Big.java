import java.math.BigInteger;

public class Big {

  public static void main (String[] args) {
    // print the powers of two
    for (int i=0; i<20; i++) {
      System.out.println (i + "\t" + pow (2, i));
      //System.out.println (i + "\t" + factorial (i));
    }
  }

  // pow raises x to the nth power

  public static BigInteger pow (int x, int n) {
    if (n==0) return BigInteger.valueOf(1);

    // find x to the n/2 recursively
    BigInteger t = pow (x, n/2);

    // if n is even, the result is t squared
    // if n is odd, the result is t squared times x

    if (n%2 == 0) {
      return t.multiply(t);
    } else {
      return t.multiply(t.multiply(BigInteger.valueOf(x)));
    }
  }

  // in factorial, I didn't need to make n or i BigIntegers,
  // since they only go up to 30

  public static BigInteger factorial (int n) {
    if (n==0) return BigInteger.valueOf (1);

    BigInteger total = BigInteger.valueOf (1);

    for (int i=1; i<=n; i++) {

      // but each time through the loop I have to convert the
      // current value of i to a BigInteger

      total = total.multiply (BigInteger.valueOf(i));
    }
    return total;
  }
}
