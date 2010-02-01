public class TreeSet {
    Comparable cargo;
    TreeSet left, right;

    public TreeSet (Object cargo) {
	this.cargo = (Comparable) cargo;
	this.left = null;
	this.right = null;
    }

    public String toString () {
	return cargo.toString ();
    }

    public static void printTree (TreeSet tree) {
	if (tree == null) return;
	printTree (tree.left);
	System.out.println (tree);
	printTree (tree.right);
    }

    public boolean add (Object x) {
	add (this, x);
	return true;
    }

    private static TreeSet add (TreeSet tree, Object x) {
	if (tree == null) return new TreeSet (x);

	int flag = tree.cargo.compareTo (x);
	if (flag == 0) return tree;

	if (flag > 0) {
	    tree.left = add (tree.left, x);
	} else {
	    tree.right = add (tree.right, x);
	}
	return tree;
    }

    public static void main (String[] args) {
	TreeSet t = new TreeSet (new Integer (5));
	for (int i=0; i<10; i++) {
	    int x = (int) Math.round (Math.random() * 20.0);
	    t.add (new Integer (x));
	}
	printTree (t);
    }
}
