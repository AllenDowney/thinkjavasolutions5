import java.awt.*;                     // Java abstract window toolkit

public class Snow extends Frame {

  public static void main(String[] args) {
    Snow c = new Snow ();             // create a window
    c.setSize (400, 400);                // set its size
    c.setBackground (Color.white);       // set the background color
    c.show ();                           // display the window
  }

  public void paint (Graphics g) {
    Rectangle bbox = getBounds ();            // find the window size
    paintBox (g, 0, 0, bbox.width, bbox.height);  // draw something!
  }

  public static void paintBox
         (Graphics g, int x, int y, int width, int height) {

    // Mr. Snowperson
    int personWidth = 30 * width / 100;
    int personHeight = height;
    int personx = x + 20 * width / 100;
    int persony = y;
    paintSnowperson (g, personx, persony, personWidth, personHeight);

    // Mrs. Snowperson
    personWidth = 90 * personWidth / 100;
    personHeight = 90 * height / 100;
    personx = 50 * width / 100;
    persony = height - personHeight;
    paintSnowperson (g, personx, persony, personWidth, personHeight);
  }

  public static void paintSnowperson
	   (Graphics g, int x, int y, int width, int height) {

    if (height < 10) return;     // refuse to draw very small snowpeople
		
    int headheight = 20 * height / 100;
    int midheight = 30 * height / 100;
    int botheight = height - midheight - headheight;
		
    int headwidth = 30 * width / 100;
    int midwidth = 60 * width / 100;
		
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
	
  public static void paintFace
	    (Graphics g, int x, int y, int width, int height) {
    int eyeheight = 20 * height / 100;
    int eyewidth = 20 * width / 100;
    int gap = (width - 2 * eyewidth) / 3;
    int brow = 25 * height / 100;
		
    // just draw two eyes
    g.fillOval (x + gap, y + brow, eyewidth, eyeheight);
    g.fillOval (x + 2 * gap + eyewidth, y + brow, eyewidth, eyeheight);
  }
	
  public static void paintRings 
	      (Graphics g, int x, int y, int width, int height) {
    // Polite methods avoid doing things like changing the current color,
    // because the calling method might not like it.  Before we change the
    // color, we stow the old value.
    Color old_color = g.getColor ();
		
    int ring_width = 30 * width/100;
    int ring_height = 60 * height/100;
    int gap = (width - 3 * ring_width) / 2;
    
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
    xx = x + (width - 2 * ring_width - gap) / 2;
    g.setColor (Color.yellow);
    g.drawOval (xx, yy, ring_width, ring_height);

    xx += ring_width + gap;
    g.setColor (Color.green);
    g.drawOval (xx, yy, ring_width, ring_height);
    
    // before returning we restore the original color
    g.setColor (old_color);
  }
}
