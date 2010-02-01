public class Name
{
	// here's an example of a global final variable -- keep it handy
	public static final int FIRST = 1;
	public static final int LAST = 2;

	public static void main(String args[])
	{
		// my name backwards is "Nella Yenwod", which could almost pass as a real name
		String n1 = "Allen Downey";
		printNameBackwards (n1);
		String n2 = "Alan Downy";  // lots of people spell both of my names wrong
				
		// my only consolation is that my spelling comes first
		System.out.println (compareNames (n1, n2));
	}
	
	public static void printNameBackwards (String name)
	{
		for (int i=name.length()-1; i>=0; i--) {
			System.out.print (name.charAt (i));
		}
		System.out.println ("");   // print a new line at the end
	}

	public static int compareNames (String n1, String n2)
	{
		// get the last names, convert them to lower case, and compare them
		String last1 = splitName(n1, LAST).toLowerCase();
		String last2 = splitName(n2, LAST).toLowerCase();
		int res = last1.compareTo (last2);
		
		// if the last names are the same, check the first names
		if (res == 0) {
			String first1 = splitName(n1, FIRST).toLowerCase();
			String first2 = splitName(n2, FIRST).toLowerCase();
			res = first1.compareTo (first2);
		}
		// return just the sign of res
		if (res > 0) return 1;
		if (res < 0) return -1;
		return 0;
	}
	
	public static String splitName (String name, int flag)
	{
		// find the space character
		int s = name.indexOf (' ');
		
		// the substring method seems to be implemented wrong, but we can work around it
		if (flag == FIRST) return name.substring (0, s);
		else return name.substring (s+1, name.length());
	}
}


