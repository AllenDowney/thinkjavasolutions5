import java.io.*;
import java.util.*;

public class Evaluator {
  Stack stack;
  String line;
  int index;

  public Evaluator (String line_) {
    index = 0;
    line = line_;
    stack = new Stack ();
  }

  public Evaluator (StringBuffer line_) {
    index = 0;
    line = line_.toString ();
    stack = new Stack ();
  }

  public int power (int x, int y) {
    if (y == 0) return 1;
    int temp = power (x, y/2);
    if (y%2 == 0) {
      return temp * temp;
    } else {
      return temp * temp * x;
    }
  }

  public int operate (int op1, int op2, char operator) {
    switch (operator) {
    case '+': return op1 + op2;
    case '-': return op1 - op2;
    case '*': return op1 * op2;
    case '/': return op1 / op2;
    case '^': return power (op1, op2);
    default:
      System.out.println ("Internal error: non-operator sent to operate.");
      System.exit(1);
    }
    return -1;
  }

  public boolean isOperator (char c) {
    switch (c) {
    case '+': case '-': case '*': case '/': case '^':
      return true;
    default:
      return false;
    }
  }

  public int charToInt (char c) {
    // precondition: we assume that c is a digit
    return (int)(c - '0');
  }

  public int popInt () {
    // precondition: we assume there is something on the stack
    return ((Integer) stack.pop()).intValue();
  }

  public int getOperand () {

    // here is where we see the advantage of making index an
    // instance variable: any procedure knows where in the
    // process we are, so it can print better error messages

    if (stack.empty ()) {
      System.out.println ("Error: tried to perform operation " 
			  + line.charAt(index)
			  + " without enough operands.");
      return -1;
    } else {
      return popInt ();
    }
  }

  public int findEndOfOperand () {
    // precondition: index indicates a position in line that
    // is the first digit of an operand.  The operand is terminated
    // by a non-digit.

    int i;
    for (i = index; i<line.length(); i++) {
      char c = line.charAt(i);
      if (!Character.isDigit (c)) return i;
    }
    return i;
  }

  public int evaluate () {
    if (line == null) return -1;

    for (index=0; index<line.length(); index++) {
      char c = line.charAt(index);

      if (Character.isDigit (c)) {
	int j = findEndOfOperand ();
	String s = line.substring (index, j);
	int operand = Integer.parseInt (s);
	stack.push (new Integer (operand));
	index = j-1;

      } else if (isOperator (c)) {
	int op2 = getOperand ();
	int op1 = getOperand ();
	int res = operate (op1, op2, c);
	stack.push (new Integer (res));

      } else if (Character.isSpaceChar (c)) {
	// do nothing

      } else {
	System.out.println ("Error: unknown character " + c);
      }
    }

    // if the stack is empty when we're done, warn the user
    int res;
    if (stack.empty ()) {
      System.out.println ("Warning: no result left on stack.");
      res = 0;
    } else {
      res = popInt ();
    }

    // if there are extra items on the stack, warn the user and
    // pop the excess
    while (!stack.empty ()) {
      System.out.print ("Warning: item left on the stack: ");
      System.out.println (popInt ());
    }  
    return res;
  }
}
