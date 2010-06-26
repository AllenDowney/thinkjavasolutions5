/**
 * @author Poorva Singal
 */

/*
 *
 * Exercise 6.4
 * In Exercise 5.9 we wrote a recursive version of power, which takes a double x and an integer n 
 * and returns x^n.  Now write an iterative method to perform the same calculation.  
 *
 */

public class Exercise04 {

  public static float power(float x, int n) {
	  int i = 0;
	  float xToPowerN = 1.0f; //should eventually equal x^n after calculations
	  
	  //n can be positive or negative, so want to take absolute value of n
	  while (i < Math.abs(n)) {
		  
		  //if n is positive, should multiply by x
		  if (n > 0) {
			  xToPowerN *= x; 
		  }
		  
		  //otherwise if x is negative, should divide by x
		  else {
			  xToPowerN /= x; 
		  }
		  i++; 
	  }
	  return xToPowerN; 
  }

  public static void main(String[] args) {
    System.out.println("Test");
    
    //test numbers
    float x = 4.0f;
    int n = 2;
    System.out.println(x + " raised to the power of " + n + " equals " + power(x,n)); 
  }
}
