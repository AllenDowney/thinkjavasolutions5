public class List {
  public int length;
  public ListNode head;

  // insertNewFirstNode
  public void insertNewFirstNode (String airport)
  {
    if (length == 0) return;

    head = new ListNode (airport, head);
    length++;
  }

  // insertNewSecondNode: add a new node to the list, putting it
  // in the second position
  public void insertNewSecondNode (String airport)
  {
    if (length == 0) return;

    head.next = new ListNode (airport, head.next);
    length++;
  }

  // print: print the list
  public void print () {
    ListNode node;

    // remember that things that get printed get buffered until
    // we print a newline or use println
    System.out.print ("(");

    // start at the beginning of the list
    node = head;

    // traverse the list, printing each element
    while (node != null) {
      System.out.print (node.airport);
      node = node.next;
      if (node != null) {
	System.out.print (", ");
      }
    }

    System.out.println (")");
  }    

  public static void main (String[] args) {

    // note: the following is a really bad way to build a list.
    // warning signs of badness: allocating two different kinds
    // of objects, accessing the fields of another class, using
    // the constant 3 to set the length

    // create an empty list
    List list = new List ();

    // create three new nodes, unlinked
    ListNode node1 = new ListNode ();
    node1.airport = "PWM";

    ListNode node2 = new ListNode ();
    node2.airport = "ORD";

    ListNode node3 = new ListNode ();
    node3.airport = "OAK";

    // link up the nodes
    node1.next = node2;
    node2.next = node3;
    node3.next = null;

    list.head = node1;
    list.length = 3;
    list.print ();

    list.insertNewFirstNode ("BOS");
    list.print ();
  }
}
