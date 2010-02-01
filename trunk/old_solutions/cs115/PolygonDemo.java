import java.applet.Applet;
import java.awt.*;

public class PolygonDemo extends java.applet.Applet
{
	public void paint(Graphics g)
	{
		// you can create an array and then set the values
		int[] xs = new int[3];
		xs[0] = 0;
		xs[1] = 399;
		xs[2] = 100;
		
		// remember, there is no nth element
		// xs[3] = 0;       ERROR!
		
		// or you can initialize the array when you create it
		int[] ys = {0, 399, 399};
		
		// but you can't use an array literal after the array is created
		// xs = {0, 0, 0};     ERROR!
		
		// draw a big, yellow triangle
		g.setColor (Color.yellow);
		g.fillPolygon (xs, ys, 3);
		
		// draw its outline in blue
		g.setColor (Color.blue);
		g.drawPolygon (xs, ys, 3);
		
		// shift the triangle up and to the right
		shift (xs, 3, 50);
		shift (ys, 3, -50);
		
		// and draw the triangle again
		g.setColor (Color.red);
		g.fillPolygon (xs, ys, 3);
	}
	
	// shift takes an array, an offset dx and the length of the array n
	// it adds dx to each element of the array and returns void
	public void shift (int[] a, int n, int dx)
	{
		for (int i=0; i<n; i++) {
			a[i] += dx;
		}
	}
}


