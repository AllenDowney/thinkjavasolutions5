import java.awt.*;                     // Java abstract window toolkit

public class Snowperson extends Frame {

  public static void main(String[] args) {
    Snowperson c = new Snowperson ();             // create a window
    c.setSize (400, 400);                // set its size
    c.setBackground (Color.white);       // set the background color
    c.show ();                           // display the window
  }

  public void paint (Graphics g) {
    Rectangle bb = getBounds ();
    bb.x = 0;
    bb.y = 0;
    paintBox (g, bb);
  }

  public static void paintBox (Graphics g, Rectangle bb) {

    // Mr. Snowperson
    int personWidth = 30 * bb.width / 100;
    int personHeight = bb.height;
    int personx = bb.x + 20 * bb.width / 100;
    int persony = bb.y;
    Rectangle mrbox =
      new Rectangle (personx, persony, personWidth, personHeight);
    paintSnowperson (g, mrbox);

    // Mrs. Snowperson
    personWidth = 90 * personWidth / 100;
    personHeight = 90 * bb.height / 100;
    personx = 50 * bb.width / 100;
    persony = bb.height - personHeight;

    Rectangle mrsbox =
      new Rectangle (personx, persony, personWidth, personHeight);
    paintSnowperson (g, mrsbox);
  }

  public static void paintSnowperson (Graphics g, Rectangle bb) {

    if (bb.height < 10) return;     // refuse to draw very small snowpeople
		
    int headheight = 20 * bb.height / 100;
    int midheight = 30 * bb.height / 100;
    int botheight = bb.height - midheight - headheight;
		
    int headwidth = 30 * bb.width / 100;
    int midwidth = 60 * bb.width / 100;
		
    int headgap = (bb.width - headwidth) / 2;
    int midgap = (bb.width - midwidth) / 2;
		
    // top oval and face
    g.drawOval (bb.x + headgap, bb.y, headwidth, headheight);
    Rectangle headBox =
      new Rectangle (bb.x + headgap, bb.y, headwidth, headheight);
    paintFace (g, headBox);
		
    // middle oval and rings
    g.drawOval (bb.x + midgap, bb.y + headheight, midwidth, midheight);
    Rectangle thoraxBox =
      new Rectangle (bb.x + midgap, bb.y + headheight, midwidth, midheight);
    paintRings (g, thoraxBox);
		
    // bottom oval and baby snowpeople
    int abdomeny =  bb.y + headheight + midheight;
    g.drawOval (bb.x, abdomeny, bb.width, botheight);
    Rectangle abdomenBox =
      new Rectangle (bb.x + bb.width/3, abdomeny, bb.width/3, botheight);
    paintSnowperson (g, abdomenBox);
  }
	
  public static void paintFace (Graphics g, Rectangle bb) {

    int eyeheight = 20 * bb.height / 100;
    int eyewidth = 20 * bb.width / 100;
    int gap = (bb.width - 2 * eyewidth) / 3;
    int brow = 25 * bb.height / 100;
		
    // just draw two eyes
    g.fillOval (bb.x + gap, bb.y + brow, eyewidth, eyeheight);
    g.fillOval (bb.x + 2 * gap + eyewidth, bb.y + brow, eyewidth, eyeheight);
  }
	
  public static void paintRings (Graphics g, Rectangle bb) {

    // Polite methods avoid doing things like changing the current color,
    // because the calling method might not like it.  Before we change the
    // color, we stow the old value.
    Color oldColor = g.getColor ();
		
    int ringWidth = 30 * bb.width/100;
    int ring_height = 60 * bb.height/100;
    int gap = (bb.width - 3 * ringWidth) / 2;
    
    int xx = bb.x;
    int yy = bb.y;
    g.setColor (Color.blue);
    g.drawOval (xx, yy, ringWidth, ring_height);
		
    xx += ringWidth + gap;
    g.setColor (Color.black);
    g.drawOval (xx, yy, ringWidth, ring_height);
		
    xx += ringWidth + gap;
    g.setColor (Color.red);
    g.drawOval (xx, yy, ringWidth, ring_height);
		
    yy = bb.y + bb.height - ring_height;
    xx = bb.x + (bb.width - 2 * ringWidth - gap) / 2;
    g.setColor (Color.yellow);
    g.drawOval (xx, yy, ringWidth, ring_height);

    xx += ringWidth + gap;
    g.setColor (Color.green);
    g.drawOval (xx, yy, ringWidth, ring_height);
    
    // before returning we restore the original color
    g.setColor (oldColor);
  }
}
