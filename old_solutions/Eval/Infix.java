import java.io.*;
import java.util.*;

public class Infix {

  public static int operate (int op1, int op2, char operator) {
    switch (operator) {
    case '+': return op1 + op2;
    case '-': return op1 - op2;
    case '*': return op1 * op2;
    case '/': return op1 / op2;
    default:
      System.out.println ("Error in operate: non-operator");
      System.exit(1);
    }
    return -1;
  }

  public static int precedence (char c) {
    switch (c) {
    case '+': case '-':
      return 0;
    case '*': case '/':
      return 1;
    default:
      System.out.println ("Error in precedence: non-operator");
      System.exit(1);
    }
    return -1;
  }

  public static boolean outranks (char c, char d) {
    return (precedence(c) > precedence (d));
  }

  public static boolean isOperator (char c) {
    switch (c) {
    case '+': case '-': case '*': case '/':
      return true;
    default:
      return false;
    }
  }

  public static int charToInt (char c) {
    return (int)(c - '0');
  }

  public static int evaluate (StringBuffer line) {
    Stack stack = new Stack ();

    for (int i=0; i<line.length(); i++) {
      char c = line.charAt(i);

      if (Character.isDigit (c)) {
	int operand = charToInt (c);
	stack.push (new Integer (operand));
      } else if (isOperator (c)) {
	int op2 = ((Integer) stack.pop()).intValue();
	int op1 = ((Integer) stack.pop()).intValue();
	int res = operate (op1, op2, c);
	stack.push (new Integer (res));
      } else {
	System.out.println ("Error");
      }
    }
    int res = ((Integer) stack.pop()).intValue();
    return res;
  }

  public static void dealWithCloser (StringBuffer out, Stack stack) {
    while (!stack.empty()) {
      char pending = ((Character) stack.pop()).charValue();
      if (pending == '(') break;
      out.append (pending);
    }
  }

  public static void dealWithOperator
    (char operator, StringBuffer out, Stack stack) {

    while (!stack.empty()) {
      char pending = ((Character) stack.peek()).charValue();
      if (pending == '(') break;

      if (outranks (operator, pending)) {
	break;
      } else {
	pending = ((Character) stack.pop()).charValue();
	out.append (pending);
      }
    }
    stack.push (new Character (operator));
    return;
  }

  public static StringBuffer translate (String line) {
    StringBuffer out = new StringBuffer (line.length());
    Stack stack = new Stack ();

    for (int i=0; i<line.length(); i++) {
      char c = line.charAt(i);

      if (Character.isDigit (c)) {
	out.append (c);
      } else if (isOperator (c)) {
	dealWithOperator (c, out, stack);
      } else if (c == '(') {
	stack.push (new Character (c));
      } else if (c == ')') {
	dealWithCloser (out, stack);
      } else {
	System.out.println ("Error unknown character:" + c);
      }
    }
    while (!stack.empty()) {
      char operator = ((Character) stack.pop()).charValue();
      out.append (operator);
    }
    return out;
  }

  public static void inputLoop () throws IOException {
    String s;
    BufferedReader stdin =
      new BufferedReader (
	new InputStreamReader (System.in));

    while (true) {
      System.out.print ("=>");
      String infix = stdin.readLine();
      if (infix == null) break;

      StringBuffer postfix = translate (infix);
      System.out.println (postfix);

      int res = evaluate (postfix);
      System.out.println (res);
    }
  }
  
  public static void main (String[] args) throws IOException {
    inputLoop ();
  }
}
