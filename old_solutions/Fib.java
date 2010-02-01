public class Fib {


  public static void main (String[] args) {
    System.out.println (factorial (3));
    System.out.println (fibonacci (3));
    System.out.println (sum (1, 4));
    System.out.println (prod (1, 4));
  }

  public static int factorial (int n) {
    if (n == 0) {
      return 1;
    } else {
      int recurse = factorial (n-1);
      int result = n * recurse;
      return result;
    }
  }

  public static int fibonacci (int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else {
      return fibonacci (n-1) + fibonacci (n-2);
    }
  }

  public static int sum (int m, int n) {
    if (m == n) {
      return n;
    } else {
      return m + sum (m+1, n);
    }
  }

  public static int prod (int m, int n) {
    if (m == n) {
      return n;
    } else {
      return n * prod (m, n-1);
    }
  }



}
