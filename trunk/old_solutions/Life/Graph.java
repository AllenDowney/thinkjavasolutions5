// in order to use the AWT, we have to import all this stuff
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Graph extends Frame
{
  // constructor for Graph
  public Graph (int width, int height)
  {
    setSize(width, height);
    setVisible(true);
  }

  // paint is invoked according to the usual rules for Containers
  public void paint (Graphics g)
  {
    Rectangle bbox = getBounds();
    setBackground (Color.white);
    g.drawOval (0, 0, bbox.width, bbox.height);
  }

  // main just instantiates Graph
  public static void main (String[] args)
  {
    Graph f = new Graph(400, 400);
  }
}
