import java.util.Iterator;

public class Test {

    public static void main (String[] args) {

	Tree tree = new Tree ();
	tree.setCargo ("one");
	tree.getLeft().setCargo ("two");
	tree.getRight().setCargo ("three");

	tree.print ();
	System.out.println (tree.getLeft().isEmpty());
	System.out.println (tree.getLeft().getLeft().isEmpty());

	tree.print ();

	Heap heap = new Heap ();
	heap.insert (new Integer (11));
	heap.insert (new Integer (12));
	heap.insert (new Integer (13));
	System.out.println (heap.remove ());
	System.out.println (heap.remove ());
    }

}




