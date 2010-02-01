import java.io.*;

public class Palin {

  public static void main (String[] args) throws IOException {

    InputStreamReader in = new InputStreamReader (System.in);
    BufferedReader keyboard = new BufferedReader (in);

    while (true) {

      System.out.println ("Type a word or phrase.");
      System.out.println ("I will check and see if it is a palindrome.");

      String s = keyboard.readLine ();
      System.out.println ("You typed: " + s);

      if (s.equals ("stop")) {
	System.out.println ("I guess that means I'll stop now.");
	System.out.println ("By the way, stop is not a palindrome.");
	return;
      }

      if (isPalindrome (s)) {
	System.out.println (s + " is a palindrome!");
      } else {
	System.out.println (s + " is not a palindrome.");
      }
      if (isPalindrome2 (s)) {
	System.out.println (s + " is a palindrome!");
      } else {
	System.out.println (s + " is not a palindrome.");
      }
      if (isPalindrome3 (s)) {
	System.out.println (s + " is a palindrome!");
      } else {
	System.out.println (s + " is not a palindrome.");
      }
    }
  }

  // middle returns a substring that includes all but the
  // first and last; only works if s has at least two characters
  public static String middle (String s) {
    return s.substring (1, s.length()-1);
  }

  // first returns the first character of a string
  // first only works if s has at least one characters
  public static char first (String s) {
    return s.charAt (0);
  }

  // last returns the last character of a string
  // last only works if s has at least one characters
  public static char last (String s) {
    return s.charAt (s.length() - 1);
  }

  // tail returns all but the last two characters of the
  // String.  it is completely bulletproof; there are no
  // preconditions.  
  public static String tail (String s) {
    if (s == null) return "";
    if (s.length() < 2) {
      return "";
    }
    return s.substring (2, s.length());
  }

  // second returns the second character of a string
  // it only works if there are at least two characters

  public static char second (String s) {
    return s.charAt (1);
  }

  public static boolean isPalindrome (String s) {
  // a recursive version of Palindrome
    if (s.length() < 2) {
	return true;
    } else if (first(s) != last(s)) {
	return false;
    } else {
	return isPalindrome (middle (s));
    }
  }

  public static boolean isPalindrome2 (String s) {
      // an iterative version of isPalindrome
    int i = 0;
    int j = s.length()-1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
	return false;
      }
      i++;
      j--;
    }
    // if we get all the way through the loop and
    // never found a mismatched pair, it must be true!
    return true;
  }

  public static boolean isPalindrome3 (String s) {
      // another iterative version of isPalindrome

    while (s.length() >= 2) {
      if (first(s) != last(s)) {
	  return false;
      } else {
	  s = middle (s);
      }
    }
    return true;
  }

  public static boolean isDupledrome (String s) {
    if (s == null) return false;
    int len = s.length();

    // the empty string is a dupledrome
    if (len == 0) return true;

    // any string with an odd number of letters is not.
    if (len%2 == 1) return false;

    // at this point, is it safe to invoke second?

    if (first(s) == second(s)) {
      return isDupledrome (tail (s));
    } else {
      return false;
    }
  }

  public static boolean isDupledrome2 (String s) {
    if (s == null) return false;
    int len = s.length();

    int i = 0;

    while (i < len-1) {
      if (s.charAt(i) != s.charAt(i+1)) {
	return false;
      }
      i = i + 1;
    }
    return true;
  }

  public static boolean hasComma (String s) {
    int index = s.indexOf(',');
    return (index != -1);
  }

  public static String convertName (String s) {
    if (hasComma (s)) {
      return s;
    }
    int space = s.indexOf(' ');
    int len = s.length();
    String first = s.substring (0, space);
    String last = s.substring (space+1, len);
    return last + ", " + first;
  }
}






