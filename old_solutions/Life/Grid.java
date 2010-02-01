// in order to use the AWT, we have to import all this stuff
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Grid
{
  public int xcells, ycells;
  public boolean[][] map;

  public Grid (int width, int height)
  {
    xcells = width;
    ycells = height;
    map = new boolean[xcells][ycells];
  }

  public void drawLines (Graphics g)
  {
    Rectangle bounds = g.getClipBounds ();

    int x1 = bounds.x;
    int x2 = x1 + bounds.width;
    int y1 = bounds.y;
    int y2 = y1 + bounds.height;

    double x = x1;
    double dx = (double)bounds.width / xcells;
    int ix;

    for (int i=0; i<xcells; i++) {
      ix = (int) (x + 0.5);
      g.drawLine (ix, y1, ix, y2);
      x += dx;
    }
    
    double y = y1;
    double dy = (double)bounds.height / ycells;
    int iy;

    for (int i=0; i<=ycells; i++) {
      iy = (int) (y + 0.5);
      g.drawLine (x1, iy, x2, iy);
      y += dy;
    }
  }
}
