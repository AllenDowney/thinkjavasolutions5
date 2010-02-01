// from Standish, Data Structures in Java
// adapted by Allen Downey for cs231 Fall 1998

public class Stack {
  StackNode topNode;

  public Stack () {
    topNode = null;
  }

  public boolean empty () {
    return (topNode == null);
  }

  public void push (Object obj) {
    topNode = new StackNode (obj, topNode);
  }

  public Object pop () {
    if (topNode == null) return null;
    Object ret = topNode.item;
    topNode = topNode.next;
    return ret;
  }

  public Object peek () {
    if (topNode == null) return null;
    return topNode.item;
  }

  // ***** Code above this line is the implementation of the Stack ADT
  // ***** Code below this line is client code that tests the implementation

  public static void main (String[] args) {

    Stack stack = new Stack ();

    Object item;
    for (int i = 0; i<10; i++) {
      item = new Integer (i);
      stack.push (item);
      System.out.println ("Inserting " + item);
    }

    while (!stack.empty()) {
      Integer i = (Integer) stack.peek ();
      System.out.println ("TOS is " + i);
      Integer j = (Integer) stack.pop ();
      System.out.println ("Removing " + j);
    }
  }
}
