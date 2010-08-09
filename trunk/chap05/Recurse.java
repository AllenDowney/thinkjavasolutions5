/**
 * @author Poorva Singal
 */

/*
 * Exercise 5.7
 * 
 * a. Create a program called Recurse.java and type in the following methods:
 *     // first: returns the first character of a given String
 *     public static char first (String s) {
 *         return s.charAt(0);
 *     }
 *     
 *     // last: returns a new String that contains all but the
 *     // first leter of the given String
 *     public static String rest (String s) {
 *         return s.substring(1, s.length());
 *     }
 *     
 *     // length: returns the length of the given String
 *     public static int length (String s) {
 *         return s.length();
 *     }
 *     
 * b. Write some code in main that tests each of these methods. Make sure they
 *     work, and make sure you understand what they do.
 *     
 * c. Write a method called printString that takes a String as a parameter and 
 *     that prints the letters of the String, one on each line.  It should be 
 *     a void method.
 *     
 * d. Write a method called printBackwards that does the same thing as 
 *     printString but that prints the String backwards (one character per line).
 * 
 * e. Write a method called reverseString that takes a String as a parameter and
 *     that returns a new String as a return value.  The new String should contain
 *     the same letters as the parameters, but in reverse order.  For example, the
 *     output of the following code
 *         String backwards = reverseString ("Allen Downey");
 *         System.out.println (backwards); 
 *     should be
 *     yenwoD nellA
 *     
 */
public class Recurse {
	
	// first: returns the first character of the given String
	public static char first(String s) {
		return s.charAt(0);
	}
	
	// last: returns a new String that contains all but the 
	// first letter of the given String
	public static String rest(String s) {
		return s.substring(1, s.length());
	}
	
	//length: returns the length of the given String
	public static int length(String s) {
		return s.length();
	}
	
	public static void printString(String s) {
		if (length(s) > 0) {
			System.out.println(first(s));
			printString(rest(s));  
		}
	}
	
	public static void printBackwards(String s) {
		if (length(s) > 1) {
			printBackwards(rest(s));
		}
		System.out.println(first(s)); 
	}
	
	public static String reverseString(String s) {
		if (length(s) == 1) {
			return s; 
		}
		else {
			String reversed = reverseString(rest(s)) + first(s); 
			return reversed; 
		}
	}
	
	public static void main(String[] args) {
		String s = "Allen Downey";
		System.out.println(first(s));
		System.out.println(rest(s));
		System.out.println(length(s));
		
		System.out.println(); 
		printString(s); 
		System.out.println(); 
		printBackwards(s);
		System.out.println();
		System.out.println(reverseString(s)); 
	}
}
