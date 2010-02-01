
public class Duplicate {

  public static void printFour (String s) {
    System.out.println (s + "\n" + s + "\n" + s + "\n" + s);
  }

  public static void printSixteen (String s) {
    printFour (s);    printFour (s);
    printFour (s);    printFour (s);
  }

  public static void printSixtyFour (String s) {
    printSixteen (s);    printSixteen (s);
    printSixteen (s);    printSixteen (s);
  }

  public static void main (String[] args) {
    String ouch = "cs115 makes my head hurt.";

    printSixtyFour (ouch);    printSixtyFour (ouch);
    printSixtyFour (ouch);    printSixtyFour (ouch);
  }
}
