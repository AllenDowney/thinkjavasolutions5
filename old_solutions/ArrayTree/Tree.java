public class Tree {
    Object[] array;
    int i;

    public Tree () {
	array = new Object[128];
	i = 1;
    }

    public Tree (Object[] array, int i) {
	this.array = array;
	this.i = i;
    }

    public boolean isEmpty () {
	return (getCargo () == null);
    }

    public Object getCargo () {
	if (i >= array.length) return null;
	return array[i];
    }

    public void setCargo (Object obj) {
	if (i >= array.length) {
	    //array = resize (array);
	}
	array[i] = obj;
    }

    public Tree getLeft () {
	return new Tree (array, 2*i);
    }

    public Tree getRight () {
	return new Tree (array, 2*i + 1);
    }

    public Tree parent () {
	return new Tree (array, i/2);
    }

    public void print () {
	if (isEmpty ()) return;
	System.out.println (array[i]);
	getLeft().print();
	getRight().print();
    }

}
