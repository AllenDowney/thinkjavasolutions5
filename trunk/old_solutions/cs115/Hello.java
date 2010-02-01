import java.util.*;

public class Hello {
  public static void main (String[] args) {
    System.out.println ("What is your name?");
    String name = Keyboard.readString ();
    System.out.println ("Hello, " + name);
  }
}
