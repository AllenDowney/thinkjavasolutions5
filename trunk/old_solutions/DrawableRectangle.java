import java.awt.*;

public class DrawableRectangle extends Rectangle {

  public void draw (Graphics g) {
    g.drawRect (x, y, width, height);
  }
}

