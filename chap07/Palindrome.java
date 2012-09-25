/**
 * @author Poorva Singal
 */

/* 
 * Exercise 7.5
 * 
 * a. Create a new program called Palindrome.java
 * 
 * b. Write a method named first that takes a String and returns the first
 *     letter, and one named last that returns the last letter.
 *     
 * c. Write a method named middle that takes a String and returns a substring
 *     that contains everything except the first and last letters.
 *     Hint: read the documentation of the substring method in the String 
 *     class.  Run a few tests to make sure you understand how substring works
 *     before you try to write middle.
 *     What happens if you invoke middle on a string that has only two letters?
 *     One letter? No letters? 
 * 
 * d. The usual definition of a palindrome is a word that reads the same both
 *     forward and backward, like "otto" and "palindromeemordnilap." An 
 *     alternative way to define a property like this is to specify a way
 *     of testing for the property.  For example, we might say, "a single 
 *     letter is a palindrome, and a two-letter word is a palindrome if the
 *     letters are the same, and any other word is palindrome if the first
 *     letter is the same as the last and the middle is a palindrome."
 *     Write a recursive method named isPalindrome that takes a String and
 *     that returns a boolean indicating whether the word is a palindrome or
 *     not.
 *     
 * e. Once you have a working palindrome checker, look for ways to simplify it
 *     by reducing the number of conditions you check.  Hint: it might be useful
 *     to adopt the definition that the empty string is a palindrome. 
 *     
 * f. One a piece of paper, figure out a strategy for checking palindromes
 *     iteratively.  There are several possible approaches, so make sure you
 *     have a solid plan before you start writing code.
 *     
 * g.  Implement your strategy in a method called isPalindromeIter.

 */
public class Palindrome {
	
	// first only works if s contains at least one letter
	public static char first(String s) {
		return s.charAt(0); 
	}
	
	// last only works if s contains at least one letter
	public static char last(String s) {
		return s.charAt(s.length() - 1); 
	}
	
	// middle returns all letters except for the first and last
	// if there are less than 2 characters in the string, then returns 
	//      empty string.
	public static String middle(String s) {
		if (s.length() <= 2) {
			return ""; 
		}
		return s.substring(1, s.length() - 1);
	}
	
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			return true; 
		}
		
		if (first(s) != last(s)) {
			return false;
		} else {
			return isPalindrome(middle(s));
		}
	}
	
	public static boolean isPalindromeIter(String s) {
		
		while (s.length() > 1) {
			if (first(s) != last(s)) {
				return false;
			}
			s = middle(s); 
		}
		return true;
	}	
}
