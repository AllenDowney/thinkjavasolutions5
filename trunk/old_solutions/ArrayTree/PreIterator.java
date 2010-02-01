import java.util.Vector;
import java.util.Iterator;

public class PreIterator implements Iterator {
    Vector v;
    int index;

    public PreIterator (Vector v) {
	this.v = v;
	this.index = 1;
    }

    public boolean hasNext () { return index < v.size (); }
    public Object next () {  return v.get (index++);  }
    public void remove () {}
}
