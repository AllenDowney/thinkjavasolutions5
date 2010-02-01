// Diamond.java

import java.applet.Applet;
import java.awt.*;

public class Diamond
	extends java.applet.Applet
{
	public void init()
	{
		setBackground (Color.white);
	}
	
	public void paint(Graphics g)
	{
		int size = 20;
		int x, y;
		
		for (int j=0; j<=20; j++) {
			for (int i=0; i<=20; i++) {
				if (i+j > 30) continue;
				if (i+j < 10) continue;
				if (i-j > 10) continue;
				if (j-i > 10) continue;
				x = i * size;
				y = j * size;
				g.setColor (Color.yellow);
				g.fillOval (x, y, size, size);
				g.setColor (Color.blue);
				g.drawOval (x, y, size, size);
			}
		}
	}
}


