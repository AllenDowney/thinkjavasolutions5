import java.awt.*;

public class Area {

  public static void printPoint (Point p) {
    System.out.println ("(" + p.x + ", " + p.y + ")");
  }

  public static Point findCenter (Rectangle rect) {
    int x = rect.x + rect.width/2;
    int y = rect.y + rect.height/2;
    return new Point (x, y);
  }

  public static void moveRect (Rectangle box, int dx, int dy) {
    box.x = box.x + dx;
    box.y = box.y + dy;
  }

  public static void main (String[] args) {
    Point blank = new Point (3, 5);
    printPoint (blank);
    System.out.println (blank);

    Rectangle box = new Rectangle (0, 0, 100, 100);
    System.out.println (box);
  }
}
