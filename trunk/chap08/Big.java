/**
 * @author Poorva Singal
 */

/*
 * Exercise 8.4
 * 
 * You are probably getting sick of the factorial method by now, but we're 
 * going to do one more version.
 * 
 * a. Create a new program called big.java and start by writing an iterative
 *     version of factorial.
 *     
 * b. Print a table of the integers from 0 to 30 along with their factorials.
 *     At some point around 15, you will prbably see that the answers are not 
 *     right any more.  Why not?
 *     
 * c. BigIntegers are built-in objects that can represent arbitrarily big
 *     integers.  There is no upper bound except the limitations of 
 *     memory size and processing speed.  Print the documentation for the
 *     BigInteger class in the java.math package, and read it.
 *      
 * d. There are several ways to create a new BigInteger, but the one I 
 *     recommend uses valueOf.  The following code converts an integer to a
 *     BigInteger:
 *          int x = 17;
 *          BigInteger = bigInteger.valueOf(x);
 *          
 *     Type in this code and try out a few simple cases like creating a 
 *     BigInteger and printing it.  Notice that println knows how to print
 *     BigIntegers!  Dn't forget to add import java.math.BigInteger to the
 *     beginning of your program.
 * 
 * e. Unfortunately, because BigIntegers are not primitive types, we cannot
 *     use the usual math operations on them.  Instead we have to use object
 *     methods like add.  In order to add two BigIntegers, you have to invoke
 *     add on one of the objects and pass the other as an argument.  For
 *     example:
 *           BigInteger small = BigInteger.valueOf(17);
 *           BigInteger big = BigInteger.valueOf(1700000000);
 *           BigInteger total = small.add(big);
 *     Try out some other methods, like multiply and pow.
 *     
 * f. Convert factorial so that it performs its calculations using BigIntegers,
 *     and then returns the BigInteger as a result.  You can leave the 
 *     parameter alone - it will still be an integer.
 *     
 * g. Try printing the table again with your modified factorial function.  Is 
 *     it correct up to 30?  How high can you make it g?  I calculated the 
 *     factorial of all the numbers from 0 to 999, but my machine is pretty 
 *     slow, so it took a while.  The last number, 999!, has 2565 digits.  
 *      
 */

import java.math.BigInteger;
public class Big {

	public static BigInteger factorial(int n) {
		if (n == 0) {
			return BigInteger.valueOf(1);
		} else {
			return BigInteger.valueOf(n).multiply(factorial(n - 1));
		}
	}
	
	public static void main(String[] args) {
		int i = 0;
		while (i <= 30) {
			System.out.println(i + "! = " + factorial(i));
			i = i + 1;
		}
	}
}
