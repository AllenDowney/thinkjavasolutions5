import java.awt.*;                  

public class Graph extends Frame {

  public static Graphics makeGraph (int width, int height) {

    // create a new Frame
    Graph c = new Graph ();
    c.setSize (width, height);
    c.setBackground (Color.white);
    c.show ();

    // the following stunt (invoking repaint and then sleeping)
    // seems to be necessary in order to make sure the Frame
    // gets initialized before the client starts drawing on it
    c.repaint ();
    try {
      Thread.sleep (100);
    } catch (InterruptedException e) {
    }

    // give the client a handle on the graphics object
    return c.getGraphics ();
  }

  // we override update and paint to make them do nothing

  public void update (Graphics g) {
    System.out.println ("update");
  }

  public void paint (Graphics g) {
    System.out.println ("paint");
  }
}
