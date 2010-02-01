import java.applet.Applet;
import java.awt.*;

public class Moire extends java.applet.Applet
{
	public void init() { setBackground(Color.white); }

	public void paint(Graphics g)
	{
		Rectangle bbox = bounds();
		int width = bbox.width;
		int height = bbox.height;
		
		// instead of drawing both targets at the same time, why can't
		// we just call paintTarget twice?
		paintTarget (g, width, height);
		
		// draw the radial Moire pattern on top of the circular one
		g.setColor (Color.yellow);
		paintRadial (g, width, height);
	}
		
	// paintTarget: takes a graphics object and the width and height of the screen.
	// draws two overlapping targets that make a Moire pattern
	public void paintTarget (Graphics g, int width, int height)
	{
		int smallest = 2;
		int biggest = 400;
		int skip = 3;
		
		for (int i = smallest; i<=biggest; i+=skip) {
			g.setColor (Color.blue);
			paintCircle (g, i, width, height);
			
			// sending width+2 and height+2 are arguments is a terrible kludge
			// because it implies that the caller knows everything about how the
			// callee works
			g.setColor (Color.red);
			paintCircle (g, i, width+2, height+2);
		}
	}
	
	// paintCircle: takes a graphics object, the width and height of the screen,
	// and the diameter of the desired circle.  Draws the circle, centered.
	public void paintCircle 
		(Graphics g, int diameter, int width, int height)
	{
		int x = width/2 - diameter/2;
		int y = height/2 - diameter/2;
		
		g.drawOval (x, y, diameter, diameter);
	}
	
	
	
	// paintRadial: width and height are the dimensions of the screen.
	// draws a radial Moire pattern
	public void paintRadial (Graphics g, int width, int height)
	{
		int cx = width/2;       // x coordinate of the center
		int cy = height/2;
		int skip = 4;
		
		for (int x = 0; x < width; x+=skip)
		{
			// line from center to top
			g.drawLine (cx, cy, x, 0);
			// line from center to bottom
			g.drawLine (cx, cy, x, height);
		}		
		for (int y = 0; y < height; y+=skip)
		{
			// line from center to left
			g.drawLine (cx, cy, 0, y);
			// line from center to right
			g.drawLine (cx, cy, width, y);
		}
	}
}


