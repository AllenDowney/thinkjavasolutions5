// in order to use the AWT, we have to import all this stuff
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Life extends Frame
{
  static Grid grid;

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

  // constructor for Life
  public Life (int width, int height)
  {
    setSize(width, height);
    setVisible(true);
    addMouseListener (new Squeak());
  }

  // ping is invoked when the mouse clicks
  public void ping (int x, int y)
  {
    Graphics g = getGraphics();
    g.fillOval (x-5, y-5, 10, 10);
  }

  // paint is invoked according to the usual rules for Containers
  public void paint (Graphics g)
  {
    setBackground (Color.white);
    grid.drawLines (g);
  }

  public static void main (String[] args)
  {
    Life f = new Life(600, 400);
    grid = new Grid (60, 40);
  }
}

