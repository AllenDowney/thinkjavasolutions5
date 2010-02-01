import java.awt.Point;

public class Point {

  public static void printPoint (Point p) {
    System.out.println ("(" + p.x + ", " + p.y + ")");
  }


  public static void main (String[] args) {
    Point blank = new Point (3, 4);
    printPoint (blank);
  }
}
