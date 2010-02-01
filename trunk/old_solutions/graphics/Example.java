import java.awt.*;

class Example {

    // demonstrate simple use of the Slate class

  public static void main (String[] args) {
    int width = 500;
    int height = 500;

    Slate slate = Slate.makeSlate (width, height);
    Graphics g = Slate.getGraphics (slate);

    g.setColor (Color.blue);
    draw (g, 0, 0, width, height);

    anim (slate, 0, 0, width, height);
  }

    // draw is taken from Section 4.14 of the book

  public static void draw (Graphics g, int x, int y, int width, int height) {
    if (height < 3) return;

    g.drawOval (x, y, width, height);

    draw (g, x, y+height/2, width/2, height/2);
    draw (g, x+width/2, y+height/2, width/2, height/2);
  }

    // anim demonstrates a simple animation

  public static void anim (Slate slate, int x, int y, int width, int height) {
    Graphics g = slate.image.getGraphics ();
    g.setColor (Color.red);

    for (int i=-100; i<500; i+=8) {
      g.drawOval (i, 100, 100, 100);
      slate.repaint ();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
      }
    }
  }
}

class Slate extends Frame {

    // image is a buffer: when Slate users draw things, they
    // draw on the buffer.  When the Slate gets painted, we
    // copy the image onto the screen.
  Image image;

  public static Slate makeSlate (int width, int height) {
    Slate s = new Slate ();
    s.setSize (width, height);
    s.setBackground (Color.white);
    s.setVisible (true);
    s.image = s.createImage (width, height);
    return s;
  }

    // when a Slate user asks for a Graphics object, we give
    // them one from the off-screen buffer.

  public static Graphics getGraphics (Slate s) {
    return s.image.getGraphics ();
  }

    // normally update erases the screen and invokes paint, but
    // since we are overwriting the whole screen anyway, it is
    // slightly faster to override update and avoid clearing the
    // screen

  public void update (Graphics g) {
    paint (g);
  }

    // paint copies the off-screen buffer onto the screen

  public void paint (Graphics g) {
    g.drawImage (image, 0, 0, null);
  }
}


