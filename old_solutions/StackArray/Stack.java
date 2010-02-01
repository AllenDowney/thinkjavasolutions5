// from Standish, Data Structures in Java
// adapted by Allen Downey for cs231 Fall 1998

public class Stack {
  private int count;
  private int capacity;
  private int capacityIncrement;
  private Object[] itemArray;

  public Stack () {
    count = 0;
    capacity = 10;
    capacityIncrement = 10;
    itemArray = new Object[capacity];
  }

  public boolean empty () {
    return (count == 0);
  }

  public void push (Object obj) {

    // this is a standard technique for making an infinite
    // array.  Whenever you run out of room, you double the size!
    if (count == capacity) {
      capacity += capacityIncrement;
      capacityIncrement *= 2;
      Object[] tempArray = new Object[capacity];
      for (int i=0; i<count;i++) {
	tempArray[i] = itemArray[i];
      }
      itemArray = tempArray;
    }
    itemArray[count] = obj;
    count++;
  }

  public Object pop () {
    if (count == 0) return null;
    count--;
    return itemArray[count];
  }

  public Object peek () {
    if (count == 0) return null;
    return itemArray[count-1];
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
