/** 
 * @author Poorva Singal
 */

/*
 * When names are recorded on a computer, they are sometimes written with the
 * first name first, like "Allen Downey," and sometimes with the last name
 * first and a comma, like "Downey, Allen."  That can make it difficult to
 * compare names and put them in alphabetical order.  
 * 
 * A related problem is that some people ave names with capital letters in
 * funny places, like my friend Beth DeSombre, or no capitals at all, like the
 * poet e.e. cummings.  When computers compare characters, they usually put 
 * all the capital letters before the lower-case letters.  As a result, 
 * computers often put names with capitals in the wrong order.
 * 
 * If you are curious, find a local phone book like a campus directory and see
 * if you can figure out the alphabetizing scheme.  Look for multiple-word
 * names like Van Houten and names with nonstandard capitalization, like
 * desJardins.  See if you can figure out the soring rules.  If you have 
 * access to a European phone book, try that, too, and see if the rules are
 * different.  
 * 
 * The result of all this nonstandardization is that it is usually not right 
 * to sort names using simple String comparison.  A common solution is to keep
 * two versions of each name: the printable version and an internal format 
 * used for sorting.  
 * 
 * In this exercise, you will write a method that compares two names by 
 * converting them to a standard format.  We will work from the bottom up, 
 * writing some helper methods and then compareName.
 * 
 * a. Create a program called Name.java.  In the documentation of String, 
 *     read about find and toLower and compareTo.  Write some simple code to
 *     test each of them and make sure you understand how they work.  
 *     
 * b. Write a method called hasComma that takes a name as an argument and
 *     that returns a boolean indicating whether it contains a comma.  If it 
 *     does, you can assume that it is in the last name first format.  
 *     
 * c. Write a method called convertName that takes a name as an argument. It
 *     should check whether it contains a comma.  If it does, it should just 
 *     return the string.  If not then it should assume that the name is in
 *     first name first format, and it should return a new string that 
 *     contains the name converted to the last name first format.
 *     
 * d. Write a method called compareName that takes two names as arguments and
 *     that returns -1 if the first comes before the second alphabetically, 0 
 *     if the names are equal alphabetically, and 1 otherwise.  Your method 
 *     should be case-insensitive, meaning that it doesn't matter whether the
 *     letters are upper- or lower-case.  
 */
public class Name {
	
	public static boolean hasComma(String name) {
		// indexOf will return -1 if a comma is not found
		return name.indexOf(',') >= 0; 
	}
	
	public static String convertName(String name) {
		if (hasComma(name)) {
			return name;
		}
		
		int index = name.indexOf(' ');
		String first = name.substring(0, index);
		String last = name.substring(index+1);
		String convertedName = last + ", " + first;
		return convertedName;	
	}
	
	public static int compareName(String name1, String name2) {
		name1 = convertName(name1).toLowerCase();
		name2 = convertName(name2).toLowerCase();
		
		if (name1.compareTo(name2) < 0) {
			return -1;
		}
		else if (name1.compareTo(name2) == 0) {
			return 0;
		}
		else {
			return 1; 
		}
	}
	
}
