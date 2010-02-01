public class Huffman {

  // the frequency table contains the frequencies for each
  // letter in the sample.  The Huffman tree is used to decode
  // strings; the code table is used for encoding strings.
  FreqTab ft;
  HuffTree ht;
  CodeTab ct;

  // constructor
  public Huffman () {
    ft = new FreqTab ();
    ht = null;
    ct = new CodeTab ();
  }

  // buildFreqTab

  public void buildFreqTab (String sample) {
    for (int i=0; i<sample.length(); i++) {
      ft.incrementFreq (sample.charAt (i));
    }
    //ft.print ();
  }

  // buildHuffTree

  public void buildHuffTree () {
    Heap seq = null;
    int count;
    HuffTree item;

    for (char c='a'; c<='z'; c++) {
      count = ft.getFreq (c);
      if (count > 0) {
	item = new HuffTree (count, c, null, null);
	seq = Heap.insert(seq, item);
      }
    }

    // Heap.printHeap (seq);

    HuffTree left, right;
    HuffTree parent = null;

    while (seq != null) {
      seq = Heap.remove (seq);
      left = (HuffTree) Heap.removedValue;
      seq = Heap.remove (seq);
      right = (HuffTree) Heap.removedValue;
      int total = left.freq + right.freq;
      parent = new HuffTree (total, '.', left, right);
      
      if (seq != null) {
	seq = seq.insert (seq, parent);
      }
    }
    ht = parent;
    //ht.print ();
  }

  // buildCodeTab

  public void buildCodeTab () {
    boolean[] path = new boolean [26];
    getCodesFromTree (ht, path, 0);
    //ct.print();
  }

  // getCodesFromTree: helper method for buildCodeTab
  public void getCodesFromTree (HuffTree tree, boolean[] path, int sofar) {

    if (tree == null) return;

    if (tree.c != '.') {
      // build a new Code based on the path so far, and add
      // a new entry to the code table
      Code code = new Code (path, sofar);
      ct.addEntry (tree.c, code);
    }

    path[sofar] = true;
    getCodesFromTree (tree.left, path, sofar+1);

    path[sofar] = false;
    getCodesFromTree (tree.right, path, sofar+1);
  }

  // encode
  public String encode (String s) {
    String out = "";

    for (int i=0; i<s.length(); i++) {
      Code code = ct.getEntry (s.charAt (i));
      out = out + code;
    }
    return out;
  }

  // decode
  public String decode (String s) {
    String out = "";
    HuffTree tree = ht;
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) == '1') {
	tree = tree.left;
      } else {
	tree = tree.right;
      }

      if (tree.isLeaf ()) {
	out = out + tree.c;
	tree = ht;
      }
    }
    return out;
  }

  public static void main (String[] args) {
    Huffman huff = new Huffman ();
    huff.buildFreqTab
      ("eeeeeeeeeeeeeeeeeeeeeeeeeeeeettttttttttnnnnnnnnniiiiissss");
    huff.buildHuffTree ();
    huff.buildCodeTab ();

    String s = huff.encode ("tennis");
    System.out.println (s);

    String u = huff.decode (s);
    System.out.println (u);

  }
}






