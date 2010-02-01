public class ListNode {
  public String airport;
  public ListNode next;

  // default constructor
  public ListNode () {
  }

  // other constructor
  public ListNode (String airport_, ListNode next_) {
    airport = airport_;
    next = next_;
  }

  public ListNode (ListNode copy) {
    airport = copy.airport;
    next = copy.next;
  }

  public void printNodeBackwards ()
  {
    if (this.next != null) {
      next.printNodeBackwards ();
    }
    System.out.print (airport + ", ");
  }

  public static int length (ListNode node)
  {
    if (node == null) return 0;
    return length (node.next) + 1;
  }
}
