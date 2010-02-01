
public class Heap extends ArrayTree {
    int next;

    public Heap () {
	next = 1;
    }

    public void add (Comparable comp) {
	setCargo (next, comp);

        int i = next;
        while (i>1) {
            int parent = parent (i);
            if (compare (i, parent) <= 0) {
                break;
            }
	    swap (i, parent);
            i = parent;
        }
	next++;
    }

    private int compare (int i, int j) {
        Comparable c1 = (Comparable) getCargo (i);
        Comparable c2 = (Comparable) getCargo (j);

        if (c1 == null) {
            if (c2 == null) {
                return 0;
            } else {
                return -1;
            }
        }
        if (c2 == null) return 1;
        return c1.compareTo (c2);
    }

    private void swap (int i, int j) {
        Object temp = getCargo (i);
        setCargo (i, getCargo (j));
        setCargo (j, temp);
    }

    public Comparable remove () {
	// the result is at the root
	Comparable result = (Comparable) getCargo(1);

	// move the last element of the array to the root
	setCargo (1, getCargo (next-1));
	next--;
	setCargo (next, null);

	reheapify (1);
	return result;
    }

    private void reheapify (int i) {
        int left = getLeft (i);
        int right = getRight (i);
        boolean winleft = compare (i, left) >= 0;
        boolean winright = compare (i, right) >= 0;

        if (winleft && winright) return;
        if (compare (left, right) > 0) {
            swap (i, left);
            reheapify (left);
        } else {
            swap (i, right);
            reheapify (right);
        }
    }

    public static void main (String[] args) {
	Heap heap = new Heap ();
	for (int i=0; i<10; i++) {
	    heap.add (new Integer (i));
	}

	for (int i=0; i<10; i++) {
	    heap.print (1);
	    System.out.println ("");
	    System.out.println (heap.remove ());
	}
    }
}
