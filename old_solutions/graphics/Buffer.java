import java.awt.*;

public class Buffer {

  public static void main (String[] args) {
    int width = 500;
    int height = 500;
    Slate slate = new Slate (width, height);
    Graphics g = slate.image.getGraphics ();

    g.setColor (Color.blue);
    draw (g, 0, 0, width, height);
    anim (slate, 0, 0, width, height);


  }

  public static void draw (Graphics g, int x, int y, int width, int height) {
    if (height == 0) return;

    g.drawOval (x, y, width, height);

    draw (g, x, y, width/2, height/2);
    draw (g, x+width/2, y, width/2, height/2);
  }

  public static void anim (Slate slate, int x, int y, int width, int height) {
    Graphics g = slate.image.getGraphics ();

    for (int i=0; i<500; i++) {
      g.drawOval (i, i, 100, 100);
      slate.repaint ();
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
      }
    }
  }
}

class Slate extends Frame {
  Image image;

  public Slate (int width, int height) {
    setSize (width, height);
    setBackground (Color.white);
    setVisible (true);
    image = createImage (width, height);
  }

  public void update (Graphics g) {
    g.drawImage (image, 0, 0, null);
  }
}
