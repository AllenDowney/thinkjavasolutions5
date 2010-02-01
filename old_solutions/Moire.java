import java.awt.*;                     // Java abstract window toolkit

public class Moire extends Frame {

  public static void moire
         (Graphics g, int x, int y, int width, int height) {
    int i = 1;
    while (i<width) {
      g.drawOval (0, 0, i, i);
      i = i + 2;
    }
  }

  public static void paintBox
         (Graphics g, int x, int y, int width, int height) {

    moire (g, x, y, width, height);
  }

  public static void main(String[] args) {
    Moire c = new Moire ();             // create a window
    c.setSize (400, 400);                // set its size
    c.setBackground (Color.white);       // set the background color
    c.show ();                           // display the window
  }

  // paint: like main, paint contains special code that gets
  // executed whenever the screen needs to be drawn or updated

  public void paint (Graphics g) {
    Rectangle bbox = getBounds ();            // find the window size
    paintBox (g, 0, 0, bbox.width, bbox.height);  // draw something!
  }
}
