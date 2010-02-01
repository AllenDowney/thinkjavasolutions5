
public class Multadd {

  public static void multadd (double a, double b, double c) {
    System.out.println (a * b + c);
  }

  public static void yikes (double x) {
    multadd (x, Math.exp(-x), Math.sqrt (1 - Math.exp(-x)));
  }


  public static void main (String[] args) {
    multadd (1.0, 2.0, 3.0);

    double a = Math.cos (Math.PI / 4);
    double c = Math.sin (Math.PI / 4);
    multadd (a, 0.5, c);

    multadd (1.0, Math.log (10.0), Math.log (20.0));

    yikes (1.0);
  }
}
