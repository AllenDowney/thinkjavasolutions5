public class List {
  public int length;
  public ListNode head;

  public void deleteFirst ()
  {
    head = head.next;
    length--;
  }

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

  public void insertBefore (ListNode node, ListNode newNode)
  {
    insertAfter (node, newNode);
    PQItem temp = node.item;
    node.item = newNode.item;
    newNode.item = temp;
  }

  public void insertAfter (ListNode node, ListNode newNode)
  {
    newNode.next = node.next;
    node.next = newNode;
    length++;
  }
}
