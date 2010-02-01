import java.io.*;
import java.util.*;

public class Checker {
  public Stack stack;

  public Checker () {
    stack = new Stack ();
  }

  public boolean match (char opener, char closer) {
    switch (closer) {
    case '}':
      return (opener == '{');
    case ')':
      return (opener == '(');
    case ']':
      return (opener == '[');
    default:
      System.out.println ("Something insane has happened.");
    }
    return true;
  }    

  public void checkCloser (char closer) {
    if (stack.empty()) {
      System.out.println ("Unbalanced");
      System.exit (1);
      return;
    }
    char opener = ((Character) stack.pop()).charValue();
    if (!match (opener, closer)) {
      System.out.println ("Unbalanced");
      System.exit (1);
    }
  }

  public void parseChar (char c) {
    switch (c) {
    case '{': case '(': case '[':
      stack.push ((Object)(new Character (c)));
      break;
    case '}': case ')': case ']':
      checkCloser (c);
      break;
    default:
    }
  }

  public void checkLine (String line) {
    for (int i = 0; i<line.length(); i++) {
      parseChar (line.charAt(i));
    }
  }

  public void endOfInput () {
    if (stack.empty()) {
      System.out.println ("All is well.");
    } else {
      System.out.println ("Unbalanced.");
    }
  }

  public static void checkFile (String filename)
                     throws FileNotFoundException, IOException {

    Checker checker = new Checker ();

    // open the file and create a BufferedReader for it
    BufferedReader in =
      new BufferedReader (
	new FileReader (filename));
    String s;

    // use the BufferedReader to get lines from the file
    while (true) {
      s = in.readLine();
      if (s == null) break;
      checker.checkLine (s);
    }
    checker.endOfInput ();
  }
  
  public static void main (String[] args)
                     throws FileNotFoundException, IOException {
    checkFile ("Balance.java");
  }
}
