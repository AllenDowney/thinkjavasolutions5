import java.util.Vector;
import java.util.Iterator;

public class Tree {
    Vector v;
    int i;

    public Tree () {
	v = new Vector ();
	i = 1;
    }

    public Tree (Vector v, int i) {
	this.v = v;
	this.i = i;
    }

    public boolean isEmpty () {
	return (getCargo () == null);
    }

    public Object getCargo () {
	if (i >= v.size ()) return null;
	return v.get (i);
    }

    public void setCargo (Object obj) {
	//System.out.println ("i = " + i);
	//System.out.println ("size = " + v.size());
	if (i >= v.size ()) v.setSize (i+1);
	v.set (i, obj);
    }

    public Tree getLeft () {
	return new Tree (v, 2*i);
    }

    public Tree getRight () {
	return new Tree (v, 2*i + 1);
    }

    public Tree parent () {
	return new Tree (v, i/2);
    }

    public void print () {
	if (isEmpty ()) return;
	System.out.println (v.get(i));
	getLeft().print();
	getRight().print();
    }

    public void traverse () {
	Iterator iterator = v.iterator ();
	while (iterator.hasNext ()) {
	    System.out.println (iterator.next ());
	}
    }    

    public PreIterator preorder () {
	return new PreIterator (v);
    }
}
