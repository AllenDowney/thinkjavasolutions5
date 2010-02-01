public class Queue {
  QueueNode topNode;

  public Queue () {
    topNode = null;
  }

  public boolean empty () {
    return (topNode == null);
  }

  public void insert (Object obj) {
    QueueNode newNode = new QueueNode (obj, null);

    if (topNode == null) {
      topNode = newNode;
    } else {
      for (QueueNode node = topNode; node != null; node = node.next) {
	if (node.next == null) {
	  node.next = newNode;
	  break;
	}
      }
    }
  }

  public Object remove () {
    if (topNode == null) return null;
    Object ret = topNode.item;
    topNode = topNode.next;
    return ret;
  }

  // ***** Code above this line is the implementation of the Queue ADT
  // ***** Code below this line is client code that tests the implementation

  public static void main (String[] args) {

    Queue Queue = new Queue ();

    Object item;
    for (int i = 0; i<10; i++) {
      item = new Integer (i);
      Queue.insert (item);
      System.out.println ("Inserting " + item);
    }

    while (!Queue.empty()) {
      Integer j = (Integer) Queue.remove ();
      System.out.println ("Removing " + j);
    }
  }
}
