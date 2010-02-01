public class Gcd {

  public static void main (String[] args) {
    System.out.println (itgcd (20, 8));
  }

  public static int gcd (int a, int b) {
    if (b == 0) {
      return a;
    } else {
      int remainder = a % b;
      int recurse = gcd (b, remainder);
      return recurse;
    }
  }

  public static int itgcd (int a, int b) {
    while (b != 0) {
      a = b;
      b = a%b;
    }
    return a;
  }
}
