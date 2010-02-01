import java.io.*;

public class Balance {

  // parseLine traverses the given String, printing all the characters,
  // with a newline at the end of each line

  public static void parseLine (String line) {
    for (int i = 0; i<line.length(); i++) {
      System.out.print (line.charAt(i));
    }
    System.out.print ("\n");
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
  }
  
  public static void main (String[] args)
                     throws FileNotFoundException, IOException {
    checkFile ("Balance.java");
  }
}
