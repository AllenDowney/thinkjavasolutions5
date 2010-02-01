import java.io.*;
import java.util.*;

public class Translator {
  public int index;
  public String line;
  public StringBuffer out;
  public Stack stack;

  public Translator (String line_) {
    index = 0;
    line = line_;
    out = new StringBuffer (line.length());
    stack = new Stack ();
  }

  public int precedence (char c) {
    switch (c) {
    case '+': case '-':
      return 0;
    case '*': case '/':
      return 1;
    case '^':
      return 2;
    default:
      System.out.println ("Internal error: non-operator in precedence.");
      System.exit(1);
    }
    return -1;
  }

  public boolean outranks (char c, char d) {
    return (precedence(c) > precedence (d));
  }

  public boolean isOperator (char c) {
    switch (c) {
    case '+': case '-': case '*': case '/': case '^':
      return true;
    default:
      return false;
    }
  }

  public char popChar () {
    // precondition: assumes that there is something to pop
    return ((Character) stack.pop()).charValue();
  }

  public char peekChar () {
    // precondition: assumes that there is something to pop
    return ((Character) stack.peek()).charValue();
  }

  public void dealWithCloser () {
    while (!stack.empty()) {
      char pending = popChar ();
      if (pending == '(') break;
      out.append (pending);
    }
  }

  public void dealWithOperator (char operator) {
    while (!stack.empty()) {

      char pending = peekChar ();
      if (pending == '(') break;

      if (outranks (operator, pending)) {
	break;
      } else {
	out.append (popChar ());
      }
    }
    // every time we push an argument, we output a space to
    // separate the arguments
    out.append (' ');
    stack.push (new Character (operator));
    return;
  }

  public int findEndOfOperand () {
    int i;
    for (i = index; i<line.length(); i++) {
      char c = line.charAt(i);
      if (!Character.isDigit (c)) return i;
    }
    return i;
  }

  public void dealWithOperand () {
    int j = findEndOfOperand ();
    String s = line.substring (index, j);
    out.append (s);
    index = j-1;
  }

  public StringBuffer translate () {
    for (index = 0; index<line.length(); index++) {
      char c = line.charAt(index);

      if (Character.isDigit (c)) {
	dealWithOperand ();
      } else if (isOperator (c)) {
	dealWithOperator (c);
      } else if (c == '(') {
	stack.push (new Character (c));
      } else if (c == ')') {
	dealWithCloser ();
      } else if (Character.isSpaceChar (c)) {
	// do nothing
      } else {
	System.out.println ("Error: unknown character" + c);
      }
    }

    // pop and output all the operators left on the stack
    while (!stack.empty()) {
      out.append (popChar ());
    }
    return out;
  }
}

