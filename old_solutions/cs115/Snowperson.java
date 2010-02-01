import java.applet.Applet;
import java.awt.*;

public class Snowperson extends Applet
{
	public void paint(Graphics g)
	{
		// find the width and height of the window
		Rectangle boundingBox = bounds ();
		int windowWidth = boundingBox.width;
		int windowHeight = boundingBox.height;
		
		// Mr. Snowperson
		int width = windowWidth/3;
		int height = windowHeight;
		int x = windowWidth/6;
		int y = 0;
		paintSnowperson (g, x, y, width, height);

		// Mrs. Snowperson
		width = (int)(0.9 * width);
		height = (int)(0.9 * height);
		x = windowWidth/2;
		y = windowHeight - height;
		paintSnowperson (g, x, y, width, height);
	}
	
	public void paintSnowperson
	    (Graphics g, int x, int y, int width, int height)
	{
		if (height < 10) return;     // refuse to draw very small snowpeople
		
		int headheight = (int)(height * 0.2);
		int midheight = (int)(height * 0.3);
		int botheight = height - midheight - headheight;
		
		int headwidth = (int)(width * 0.3);
		int midwidth = (int)(width * 0.6);
		
		int headgap = (width - headwidth) / 2;
		int midgap = (width - midwidth) / 2;
		
		// top oval and face
		g.drawOval (x + headgap, y, headwidth, headheight);
		paintFace (g, x + headgap, y, headwidth, headheight);
		
		// middle oval and rings
		g.drawOval (x + midgap, y + headheight, midwidth, midheight);
		paintRings (g, x + midgap, y + headheight, midwidth, midheight);
		
		// bottom oval and baby snowpeople
		y += headheight + midheight;
		g.drawOval (x, y, width, botheight);
		paintSnowperson (g, x + width/4, y, width/2, botheight);
	}
	
	public void paintFace
	    (Graphics g, int x, int y, int width, int height)
	{
		int eyeheight = (int)(height * 0.2);
		int eyewidth = (int)(height * 0.2);
		int gap = (width - 2 * eyewidth) / 3;
		int brow = (int)(height * 0.25);
		
		// just draw two eyes
		g.fillOval (x + gap, y + brow, eyewidth, eyeheight);
		g.fillOval (x + 2 * gap + eyewidth, y + brow, eyewidth, eyeheight);
	}
	
	public void paintRings 
	     (Graphics g, int x, int y, int width, int height)
	{
		// Polite methods avoid doing things like changing the current color,
		// because the calling method might not like it.  Before we change the
		// color, we stow the old value.
		Color old_color = g.getColor ();
		
		int ring_width = (int) (0.3 * width + 0.5);
		int ring_height = (int) (0.6 * height + 0.5);
		int gap = (int) ((width - 3 * ring_width) / 2.0);
		
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
		
		yy = y + height - ring_height;
		xx = x + (int) ((width - 2 * ring_width - gap) / 2.0);
		g.setColor (Color.yellow);
		g.drawOval (xx, yy, ring_width, ring_height);

		xx += ring_width + gap;
		g.setColor (Color.green);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		// before returning we restore the original color
		g.setColor (old_color);
	}
}


