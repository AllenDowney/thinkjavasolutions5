// Mouse.java
// a minimal application that puts up a window and responds to mouse
// clicks

// in order to use the AWT, we have to import all this stuff
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Mouse extends Frame
{
  class Crunch extends WindowAdapter
  {
    public void windowClosing (WindowEvent e)
    {
      System.out.println ("Bye!");
      System.exit(0);
    }
  }

  // squeak is an internal class that provides event-handling
  // routines for mouse clicks
  class Squeak extends MouseAdapter
  {
    // mouseClicked is one of the mouse events
    public void mouseClicked (MouseEvent e)
    {
      int x = e.getX();
      int y = e.getY();
      ping (x, y);
    }
  }

  // constructor for Mouse
  public Mouse (int width, int height)
  {
    setSize(width, height);
    setVisible(true);
    addMouseListener (new Squeak());
    addWindowListener (new Crunch());
  }

  // ping is invoked when the mouse clicks
  public void ping (int x, int y)
  {
    // outside of paint, we have to use getGraphics
    Graphics g = getGraphics();
    System.out.println ("Ouch!");

    // anything we draw outside of paint will not get redrawn
    g.fillOval (x-5, y-5, 10, 10);
  }

  // paint is invoked according to the usual rules for Containers
  public void paint (Graphics g)
  {
    setBackground (Color.white);
    g.drawString ("Click the mouse to draw circles", 100, 200);
  }

  // main just instantiates Mouse
  public static void main (String[] args)
  {
    Mouse f = new Mouse(400, 400);
  }
}
