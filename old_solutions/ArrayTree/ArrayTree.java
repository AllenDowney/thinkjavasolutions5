public class ArrayTree {
    Object[] array;

    public ArrayTree () {
	array = new Object[128];
    }

    public Object getCargo (int i) {
	return array[i];
    }

    public void setCargo (int i, Object obj) {
        array[i] = obj;
    }

    public int getLeft (int i)  { return 2*i; }
    public int getRight (int i) { return 2*i + 1; }
    public int parent (int i)   { return i/2; }

    public void print (int i) {
        Object cargo = getCargo (i);
        if (cargo == null) return;
        System.out.print (cargo + " ");
        print (getRight (i));
        print (getLeft (i));
    }

    public static void main (String[] args) {
	ArrayTree tree = new ArrayTree ();
	tree.setCargo (1, "cargo for root");

	tree.setCargo (tree.getLeft(1), "cargo for left");
	tree.setCargo (tree.getRight(1), "cargo for right");

	tree.print (1);
    }
}
