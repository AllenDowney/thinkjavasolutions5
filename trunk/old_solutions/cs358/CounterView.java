import java.awt.*;
import java.awt.event.*;

public class CounterView extends Frame {

  // a reference to the model
  Counter counter;

  // GUI components
  Button inc;
  Button zero;
  Button dec;
  Button exit;
  Label label;
  
  // the following are internal classes that provide
  // a listener for each button

  class Inc implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      counter.increment ();
      label.setText (counter.getValueString ());
    }
  }

  class Zero implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      counter.setValue (0);
      label.setText (counter.getValueString ());
    }
  }

  class Dec implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      counter.decrement ();
      label.setText (counter.getValueString ());
    }
  }

  // hitting the exit button closes the frame
  class Exit implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      dispose ();
    }
  }

  // when the window closes, it takes the application with it.
  // probably only one window in each program should do this.
  static class WL extends WindowAdapter {
    public void windowClosed (WindowEvent e) {
      System.exit (0);
    }
  }

  // constructor
  public CounterView (Counter c) {

    // move a reference to the model into an instance variable
    counter = c;

    // create all the GUI components
    label = new Label (counter.getValueString ());
    inc = new Button ("+");
    zero = new Button ("0");
    dec = new Button ("-");
    exit = new Button ("Exit");

    // attach listeners to the components
    inc.addActionListener (new Inc());
    zero.addActionListener (new Zero());
    dec.addActionListener (new Dec());
    exit.addActionListener (new Exit());

    // layout the frame as a column of three panels
    setLayout (new GridLayout (3, 1));
    Panel top = new Panel ();
    Panel middle = new Panel ();
    Panel bottom = new Panel ();
    add (top);  add (middle);  add (bottom);

    // add the components to the panels
    top.add (label);
    middle.add (inc);
    middle.add (zero);
    middle.add (dec);
    bottom.add (exit);

    // attach a listener to the frame and display it
    addWindowListener (new WL ());
    setSize (300, 200);
    setVisible (true);
  }
}


