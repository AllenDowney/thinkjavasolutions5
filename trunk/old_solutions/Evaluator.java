import java.io.*;
import java.lang.*;
import java.util.*;

public class Evaluator {
    private static Stack stack;
    private static StringTokenizer st;

    public static void main (String[] args) {
	Evaluator e = new Evaluator ();
	e.evaluate ("3 2 +");
    }

    public Evaluator() {
	stack = new Stack();
    }

    //evaluates the given postfix expression, returning an int
    public void evaluate(String s) {
	int result = 0; //remember for later
	parseExpression(s); //break up input String
	
	    //fill stack w/ operands
	    while(st.hasMoreTokens()) {
	   
	       String t = st.nextToken(); //hold this value for later
System.out.println("t = " + t);
	       if(!isOperand(t)&&!isOperator(t.charAt(0))&&!isSpace(t)) {
		   System.out.println("input error");
		   System.exit(1);
	       }else if(isOperand(t)) {
System.out.println("t = " + t);
Integer i = new Integer (t);
System.out.println("Integer t = " + i);
	            stack.push(i);

	        //remove last 2 pushed operands
	        }else if(isOperator(t.charAt(0))) {
		    if(stack.empty()) {
			break;
		    }else{
			Integer temp = (Integer)stack.pop();
			System.out.println (temp);		       
		        int op1 = temp.intValue();
System.out.println("op 1 = " + op1);
		        int op2 = ((Integer)stack.pop()).intValue();
System.out.println("op 2 = " + op2);
		        result = performOperation(op1, op2, t.charAt(0));
		    }
	        }else{
		    //do nothing
		}

	        //add result to stack for future calculations
	       //stack.push(new Integer(result)); 
	    }
	    System.out.println("result = " + result);    
    }

    //determines whether given character is an operator
    public static boolean isOperator(char c) {
	switch(c) {
	    case '+': case '-': case '*': case '/':
	        return true;
	}
	return false;
	
    }

    //determines whether given character is an operand
    public static boolean isOperand(String s) {

	//check to see whether s is a digit
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //determines whether given token is a space
    public static boolean isSpace(String s) {
	if(s.equals(" ")) {
	    return true;
        }
        return false;
    }

    //breaks up given String expression into tokens
    public static void parseExpression(String s) {
	st = new StringTokenizer(s, "+-*/ ", true); //update st
    }

    //performs the given mathematical operation on the 
    //given integers
    public static int performOperation(int op1, int op2, 
					   char operator) {
System.out.println("operator = " + operator);
System.out.println("op1 = " + op1);
System.out.println("op2 = " + op2);

	switch(operator) {

	    case '+' :
		return op2 + op1;
	    case '-' :
		return op2 - op1;
	    case '*' :
		return op2 * op1;
	    case '/' :
		return op2 / op1;
	}
	return 0;
    }
  
}

