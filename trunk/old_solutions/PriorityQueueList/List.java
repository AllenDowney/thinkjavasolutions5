public class List {
  public int length;
  public ListNode head;

  // insertNewFirstNode: Exercise 1
  public void insertNewFirstNode (PQItem item)
  {
    head = new ListNode (item, head);
    length++;
  }

  // deleteFirst: Exercise 2
  public void deleteFirst ()
  {
    head = head.next;
    length--;
  }

    // insertNewLastNode
  public void insertNewLastNode (PQItem item)
  {
    ListNode newNode = new ListNode (item, null);

    if (head == null) {
      head = newNode;
    } else {
      ListNode node = head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = newNode;
    }
    length++;
  }

  // insertBefore: insert newNode into the list to which node belongs,
  // so that new appears in the list before node
  public void insertBefore (ListNode node, ListNode newNode)
  {
    insertAfter (node, newNode);
    PQItem temp = node.item;
    node.item = newNode.item;
    newNode.item = temp;
  }

  // insertAfter: insert newNode into the list to which node belongs,
  // so that newNode appears in the list after node
  public void insertAfter (ListNode node, ListNode newNode)
  {
    newNode.next = node.next;
    node.next = newNode;
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
      System.out.print (node.item);
      node = node.next;
      if (node != null) {
	System.out.print (", ");
      }
    }
    System.out.println (")");
  }
}
