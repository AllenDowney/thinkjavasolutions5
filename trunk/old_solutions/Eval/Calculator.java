import java.io.*;
import java.util.*;

public class Calculator {

  public static void inputLoop () throws IOException {
    String s;
    BufferedReader stdin =
      new BufferedReader (
	new InputStreamReader (System.in));

    while (true) {
      System.out.print ("=>");
      String infix = stdin.readLine();
      if (infix == null) break;

      Checker checker = new Checker ();
      checker.checkLine (infix);
      checker.endOfInput ();

      Translator t = new Translator (infix);
      StringBuffer postfix = t.translate ();
      System.out.println (postfix);

      Evaluator e = new Evaluator (postfix);
      int res = e.evaluate ();
      System.out.println (res);
    }
  }
  
  public static void main (String[] args) throws IOException {
    inputLoop ();
  }
}
