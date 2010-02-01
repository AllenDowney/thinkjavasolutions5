import java.io.*;

public class Eval {

  public static void parseLine (String line) {
    System.out.println (line);
  }

  public static void inputLoop () throws IOException {
    String s;
    BufferedReader stdin =
      new BufferedReader (
	new InputStreamReader (System.in));

    // use the BufferedReader to get lines from the file
    while (true) {
      System.out.print ("=>");
      s = stdin.readLine();
      if (s == null) break;
      parseLine (s);
    }
  }
  
  public static void main (String[] args) throws IOException {
    inputLoop ();
  }
}
