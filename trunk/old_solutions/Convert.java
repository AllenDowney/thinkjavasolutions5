import java.io.*;

public class Convert {
  public static void main (String[] args) throws IOException {
    
    BufferedInputStream bis = new BufferedInputStream (System.in);
    DataInput in = new DataInput (bis);

    int x = in.readInt ();
    System.out.println ("Hello" + x);
  }
}
