import java.applet.Applet;
import java.awt.*;

public class Olympics extends java.applet.Applet
{
	// init: gets invoked once when execution begins
	public void init()
	{
		setBackground (Color.white);
	}

	// paint: gets invoked whenever the window gets resized
	public void paint(Graphics g)
	{
		// find the width and height of the window
		Rectangle boundingBox = bounds ();
		int windowWidth = boundingBox.width;
		int windowHeight = boundingBox.height;
		
		// find the coordinates of a bounding box that is one-third of the
		// window width
		int x = windowWidth/3;
		int y = 0;
		int width = windowWidth/3;
		int height = windowHeight;
		paintRings (g, x, y, width, height);
	}
	
	// paintRings: takes a canvas and a bounding box; draw Olympic rings in the box
	public void paintRings (Graphics g, int x, int y,
											int width, int height)
	{
		// calculate the size of the rings -- 0.3 and 0.6 are the parameters that
		// control the aspect ratio and overlap of the rings
		int ring_width = (int) (0.3 * width + 0.5);
		int ring_height = (int) (0.6 * height + 0.5);
		int gap = (int) ((width - 3 * ring_width) / 2.0);
		
		// NO NUMBERS BEYOND THIS POINT !
		
		// draw the top row, left to right
		int xx = x;
		int yy = y;
		g.setColor (Color.blue);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		xx += ring_width + gap;
		g.setColor (Color.black);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		xx += ring_width + gap;
		g.setColor (Color.red);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		// draw the bottom row
		yy = height - ring_height;
		xx = x + (int) ((width - 2 * ring_width - gap) / 2.0);
		g.setColor (Color.yellow);
		g.drawOval (xx, yy, ring_width, ring_height);

		xx += ring_width + gap;
		g.setColor (Color.green);
		g.drawOval (xx, yy, ring_width, ring_height);
	}
}


