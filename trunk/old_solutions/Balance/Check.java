import java.io.*;
import java.util.Stack;

public class Check {
  public static Stack stack = new Stack ();

  public static boolean match (char opener, char closer) {
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

  public static void checkCloser (char closer) {
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

  public static void parseChar (char c) {
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

  // parseLine traverses the given String, printing all the characters,
  // with a newline at the end of each line

  public static void parseLine (String line) {
    for (int i = 0; i<line.length(); i++) {
      parseChar (line.charAt(i));
    }
  }

  // checkFile reads each line of the given file and passes it to parseLine

  public static void checkFile (String filename)
                     throws FileNotFoundException, IOException {

    // open the file and create a BufferedReader for it
    BufferedReader in =
      new BufferedReader (
	new FileReader (filename));
    String s;

    // use the BufferedReader to get lines from the file
    while (true) {
      s = in.readLine();
      if (s == null) break;
      parseLine (s);
    }

    if (stack.empty()) {
      System.out.println ("All is well.");
    } else {
      System.out.println ("Unbalanced.");
    }
  }
  
  public static void main (String[] args)
                     throws FileNotFoundException, IOException {
    checkFile ("Test.java");
  }
}









