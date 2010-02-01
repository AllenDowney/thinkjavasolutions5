
public class Date {

  public static void printAmerican
    (String day, int date, String month, int year) {
    
    System.out.println (day + ", " + month + " " + date + ", " + year);
  }

  public static void printEuropean
    (String day, int date, String month, int year) {
    
    System.out.println (day + " " + date + " " + month + ", " + year);
  }

  public static void printMartian
    (int month, int date, int year) {
    
    System.out.println (month + "" + date + year);
  }

  public static void main (String[] args) {

    String day = "Wednesday";
    int date = 17;
    String month = "February";
    int monthNum = 2;
    int year = 1999;

    System.out.println ("American format:");
    printAmerican (day, date, month, year);
    System.out.println ("European format:");
    printEuropean (day, date, month, year);
    System.out.println ("Martian format:");
    printMartian (monthNum, date, year);
  }
}
