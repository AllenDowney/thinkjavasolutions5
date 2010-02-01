public class evalExpr
{
	public static void main(String args[])
	{
		// it turns out that parseInt cannot handle spaces, so I will leave them out
		String s = "17-23+2";
		System.out.println (evalExpr (s));
	}
	
	public static int evalExpr (String s)
	{
		// find the first operator (+ or -)
		int i = findOp (s);
		
		// if there are no operators, just convert the string to integer
		if (i == -1) return Integer.parseInt (s);
		
		// split the string at the first operator
		String first = s.substring (0, i);
		String last = s.substring (i+1);

		// convert the first string and evaluate the second string recursively.
		// either add or subtract the results, depending on the operator
		if (s.charAt (i) == '+') {
			return Integer.parseInt (first) + evalExpr (last);
		} else if (s.charAt (i) == '-') {
			return Integer.parseInt (first) - evalExpr (last);
		} else {
			System.out.println ("Illegal expression format:" + s);
			return 0;
		}
	}
	
	public static int findOp (String s)
	{
		// look for a + or a i
		int i = s.indexOf ('+');
		int j = s.indexOf ('-');
		
		// if either operator is absent, return the index of the other
		if (i == -1) return j;
		if (j == -1) return i;
		
		// if both operators are present, return the index of the first one
		if (i < j) return i;
		return j;
	}
}


