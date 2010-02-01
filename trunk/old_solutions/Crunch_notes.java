
public class Crunch {

  public static void main (String[] args) {

    // notice the different ways of invoking void
    // methods and fruitful methods
    printReverse ("Allen");
    System.out.println (reverse("Allen"));

    String s = encode ("O, frabjuous day!", 13);
    System.out.println (s);
    System.out.println (encode(s, -13));
  }

  public static void printReverse (String s) {
    if (s == null) return;
    int i = s.length() - 1;
    while (i >= 0) {
      System.out.print (s.charAt (i));
      i--;
    }
    System.out.println ("");
  }

  public static String reverse (String s) {
    if (s == null) return null;
    if (s.length() == 0) return s;
    return reverse (tail(s)) + first(s);
  }

  public static String encode (String s, int n) {
    int i = 0;
    int len = s.length();
    String result = "";

    while (i < len) {
      char convertedChar = convert (s.charAt (i), n);
      result = result + convertedChar;
      i++;
    }
    return result;
  }

  public static char convert (char c, int n) {
    char result = c;
    if (isUpper (c)) {      
      result = rotate (c, n, 'A', 'Z');
    } else if (isLower (c)) {
      result = rotate (c, n, 'a', 'z');
    }
    return result;
  }

  public static boolean isUpper (char c) {
    return (c >= 'A' && c <= 'Z');
  }

  public static boolean isLower (char c) {
    return (c >= 'a' && c <= 'z');
  }

  public static char rotate
                     (char c, int n, char low, char high) {
    int result = c + n;
    if (result > high) {
      int dist = result - high;
      result = low + dist - 1;
    }
    if (result < low) {
      int dist = low - result;
      result = high - dist + 1;
    }
    return (char)result;
  }
}



