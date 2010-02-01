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
		Rectangle bb = new Rectangle ();  // create new rectangle
		bb.width = windowWidth/3;
		bb.height = windowHeight;
		bb.x = windowWidth/6;
		bb.y = 0;
		paintSnowperson (g, bb);

		// Mrs. Snowperson
		bb.width = (int)(0.9 * bb.width);   // reuse the old rectangle
		bb.height = (int)(0.9 * bb.height);
		bb.x = windowWidth/2;
		bb.y = windowHeight - bb.height;
		paintSnowperson (g, bb);
	}
	
	public void paintSnowperson (Graphics g, Rectangle bb)
	{
		if (bb.height < 10) return;     // refuse to draw very small snowpeople
		
		int headheight = (int)(bb.height * 0.2);
		int midheight = (int)(bb.height * 0.3);
		int botheight = bb.height - midheight - headheight;
		
		int headwidth = (int)(bb.width * 0.3);
		int midwidth = (int)(bb.width * 0.6);
		
		int headgap = (bb.width - headwidth) / 2;
		int midgap = (bb.width - midwidth) / 2;
		
		// top oval and face -- A new rectangle for each segment is not necessary...
		g.drawOval (bb.x + headgap, bb.y, headwidth, headheight);
		Rectangle face = new Rectangle 
			(bb.x + headgap, bb.y, headwidth, headheight);
		paintFace (g, face);
		
		// middle oval and rings -- but it makes it possible to use the easy way to...
		g.drawOval (bb.x + midgap, bb.y + headheight, midwidth, midheight);
		Rectangle thorax = new Rectangle 
			(bb.x + midgap, bb.y + headheight, midwidth, midheight);
		paintRings (g, thorax);
		
		
		// bottom oval and baby snowpeople -- create rectangles.
		bb.y += headheight + midheight;
		g.drawOval (bb.x, bb.y, bb.width, botheight);
		Rectangle abdomen = new Rectangle
			(bb.x + bb.width/4, bb.y, bb.width/2, botheight);
		paintSnowperson (g, abdomen);
	}
	
	public void paintFace (Graphics g, Rectangle bb)
	{
		int eyeheight = (int)(bb.height * 0.2);
		int eyewidth = (int)(bb.height * 0.2);
		int gap = (bb.width - 2 * eyewidth) / 3;
		int brow = (int)(bb.height * 0.25);
		
		// just draw two eyes
		g.fillOval (bb.x + gap, bb.y + brow, eyewidth, eyeheight);
		g.fillOval 
			(bb.x + 2 * gap + eyewidth, bb.y + brow, eyewidth, eyeheight);
	}
	
	public void paintRings (Graphics g, Rectangle bb)
	{
		Color old_color = g.getColor ();
		
		int ring_width = (int) (0.3 * bb.width + 0.5);
		int ring_height = (int) (0.6 * bb.height + 0.5);
		int gap = (int) ((bb.width - 3 * ring_width) / 2.0);
		
		int xx = bb.x;
		int yy = bb.y;
		g.setColor (Color.blue);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		xx += ring_width + gap;
		g.setColor (Color.black);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		xx += ring_width + gap;
		g.setColor (Color.red);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		yy = bb.y + bb.height - ring_height;
		xx = bb.x + (int) ((bb.width - 2 * ring_width - gap) / 2.0);
		g.setColor (Color.yellow);
		g.drawOval (xx, yy, ring_width, ring_height);

		xx += ring_width + gap;
		g.setColor (Color.green);
		g.drawOval (xx, yy, ring_width, ring_height);
		
		g.setColor (old_color);
	}
}


