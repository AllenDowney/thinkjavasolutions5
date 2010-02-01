
public class Date {

  public static void main (String[] args) {

    // to save space, I am declaring and assigning these
    // variables one on line
    String day = "Wednesday";
    int date = 17;
    String month = "February";
    int year = 1999;

    System.out.println ("American format:");
    System.out.println (day + ", " + month + " " + date + ", " + year);

    System.out.println ("European format:");
    System.out.println (day + " " + date + " " + month + ", " + year);
  }
}
