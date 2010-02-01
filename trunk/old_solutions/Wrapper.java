import java.io.*;

public class Wrapper {

  public static void main (String[] args) throws IOException {

    Integer i = new Integer (17);
    Double d = new Double (3.14159);

    String istring = i.toString();
    String dstring = d.toString();

    int iprim = i.intValue ();
    double dprim = d.doubleValue ();

    String base6 = "12345";
    int base10 = Integer.parseInt (base6, 6);
    System.out.println (base10);

    System.out.println (istring);
    System.out.println (dstring);
  }
}
