import java.applet.Applet;
import java.awt.*;

public class Noah extends java.applet.Applet
{
	public void paint(Graphics g)
	{
		Rectangle bbox = bounds();
		
		drawArc2 (g, bbox);
	}
	
	public void drawArc (Graphics g, Rectangle bbox)
	{
		int n = (bbox.width + bbox.height) / 10;
		double theta = 0.0;
		double dtheta = Math.PI/n;
		
		int oldx = bbox.width;
		int oldy = 0;
		int newx, newy;
		
		// in general it is more reliable to use integers as counters, rather than doubles
		for (int i=0; i<=n; i++) {
			newx = (int) (Math.cos (theta) * bbox.width);
			newy = (int) (Math.sin (theta) * bbox.height);
			g.drawLine (oldx, oldy, newx, newy);
			
			theta += dtheta;
			// this "old = new" swap is a common idiom
			oldx = newx;  oldy = newy;
		}
	}
	
	public void drawArc2 (Graphics g, Rectangle bbox)
	{
		int n = (bbox.width + bbox.height) / 10;
		double theta = 0.0;
		double dtheta = Math.PI/n;
		
		// since i goes from 0 to n, we need n+1 array elements
		int[] xs = new int[n+1];
		int[] ys = new int[n+1];
		
		for (int i=0; i<=n; i++) {
			xs[i] = (int) (Math.cos (theta) * bbox.width);
			ys[i] = (int) (Math.sin (theta) * bbox.height);
			theta += dtheta;
		}
		
		g.drawPolygon (xs, ys, n+1);
	}
}


