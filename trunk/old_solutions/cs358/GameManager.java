import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class CounterView extends Frame {

  GameManager gm;
  
  // when the window closes, it takes the application with it.
  // probably only one window in each program should do this.
  static class WL extends WindowAdapter {
    public void windowClosed (WindowEvent e) {
      System.exit (0);
    }
  }

  // constructor
  public CounterView (Counter c) {

    gm = new GameManager (300,200);
    add (gm);

    // attach a listener to the frame and display it
    addWindowListener (new WL ());
    setSize (300, 200);
    setVisible (true);
  }
}




public class GameManager extends Canvas implements Runnable {

   // variables that control game time
   static final long FRAME_RATE = 15L;
   long game_clock;
   Thread event_loop;
   ThreadGroup tg;

   // variables for graphics
   Graphics screen_display, screen_buffer;
   Image buffer_image;

   // dimensions of the screen
   int width, height;

   GameManager(int width, int height) {
      setSize(width, height);
   }

   public void startGame() {

      Dimension size = getSize();
      width = size.width;
      height = size.height;
      
      initGame();

      // Initialize any input event listeners
      startInput();

      // Store game's graphics context (the actual display)
      screen_display = getGraphics();

      // Make the offscreen image buffer
      buffer_image = createImage(width, height);
      // ...and the ``graphics context'' for the buffer
      screen_buffer = buffer_image.getGraphics();

      // Start the game event loop in its own thread
      tg = Thread.currentThread().getThreadGroup();
      event_loop = new Thread(tg, this);
      event_loop.start();
   }

   public void initGame() {
   }
   
   public void startInput() {
   }

   public void run() {
      long t;

      do {
         // Handle recorded input events
         processInput();
         
         // Run the game for one tick
         updateGame();
         
         // Paint new frame on screen buffer
         paintFrame(screen_buffer);
         
         // Transfer buffer contents to screen
         paintScreen();

         // Compute how much time is left for the current
         // "animation frame".  If there is time left, sleep to
         // make up the difference.  This should give a consistent
         // frame rate for the game.
         t = (game_clock + (1000L / FRAME_RATE)) - System.currentTimeMillis();
         if (t > 0) {
            try {
               event_loop.sleep(t);
            } catch (InterruptedException e) {
            }
         } else {
            System.out.println("Game clock overrun: " + t);
         }
         game_clock = System.currentTimeMillis();
      } while (true);
   }
   
   public void updateGame() {
   } 

   public void processInput() {
   }
   
   public synchronized void paintScreen() {
      long t = (game_clock + (1000L / FRAME_RATE))
	     - System.currentTimeMillis();
      
      // Send request to paint the frame to the screen
      // Try to make it happen within the frame rate time
      repaint(t, 0, 0, width, height);
      
      // Painting occurs in a separate thread.  We must make
      // sure the painting finishes before we continue, or
      // the wrong image might get painted.
      try {
         wait();
      } catch (InterruptedException e) {
      }
   }
   
   public void update(Graphics g) {
      paint(g);
   }
   
   public void paintFrame(Graphics g) {
      g.setColor(getBackground());
      g.fillRect(0, 0, width, height);
   }
   
   // To paint, copy offscreen buffer to screen.  Make sure
   // this happens without interruption.
   public synchronized void paint(Graphics g) {
      screen_display.drawImage(buffer_image, 0, 0, null);
      
      // Tell others threads (like the main game loop)
      // to wake back up
      notifyAll();
   }
      
}
