
public class Crunch {

  public static void main (String[] args) {

    // notice the different ways of invoking void
    // methods and fruitful methods
    printReverse ("Allen");
    System.out.println (reverse("Allen"));

    String s = encode ("Oh, frabjuous day.  Calloo!  Callay!", 13);
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

  // first returns the first character of a string
  // first only works if s has at least one characters
  public static char first (String s) {
    return s.charAt (0);
  }

  // tail returns all but the first character of the
  // String.  it is completely bulletproof; there are no
  // preconditions.  
  public static String tail (String s) {
    if (s == null) return "";
    int len = s.length();
    if (len == 0 || len == 1) {
      return "";
    }
    return s.substring (1, len);
  }

  // REVERSE: a recursive implementation of reverse.  It takes
  // a String and returns a new string that contains the same
  // letters, backwards.

  public static String reverse (String s) {
    if (s == null) return null;
    if (s.length() == 0) return s;
    return reverse (tail(s)) + first(s);
  }

  // ENCODE: traverses the String and converts the characters
  // one at a time.  Accumulates the result string by appending
  // each character.

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

  // CONVERT: upper and lower case letters get converted
  // using rotate.  Other characters are left unchanged

  public static char convert (char c, int n) {
    char result = c;
    if (isUpper (c)) {      
      result = rotate (c, n, 'A', 'Z');
    } else if (isLower (c)) {
      result = rotate (c, n, 'a', 'z');
    }
    return result;
  }

  // isUpper and isLower simply test the case of characters.
  // non-letters return false for both

  public static boolean isUpper (char c) {
    return (c >= 'A' && c <= 'Z');
  }

  public static boolean isLower (char c) {
    return (c >= 'a' && c <= 'z');
  }

  // ROTATE: this method has been generalized to deal with both
  // upper and lower case letters, depending on the values
  // of low and high, which are 'a' and 'z' for lower case
  // letters and 'A' and 'Z' for upper.

  public static char rotate (char c, int n, char low, char high) {
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



