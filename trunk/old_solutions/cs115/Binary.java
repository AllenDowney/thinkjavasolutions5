public class Binary {

  public static void binary (int x) {
    if (x == 0) {
      return;
    } else {
      binary (x/2);
    }

    System.out.print (x%2);
  }

  public static void main (String[] args) {
    binary (5);
    System.out.println ("");
  }
}
