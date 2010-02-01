public class Huffman {

  // the frequency table contains the frequencies for each
  // letter in the sample
  FreqTab ft;

  // constructor
  public Huffman () {
    ft = new FreqTab ();
  }

  // buildFreqTab: traverses the sample string and invokes
  // incrementFreq to count the number of times each letter
  // appears

  public void buildFreqTab (String sample) {

    // fill me in ********************

  }

  // buildHuffTree
  public void buildHuffTree () {

    // don't fill me in yet 

  }

  // buildCodeTab
  public void buildCodeTab () {

    // don't fill me in yet 

  }

  // encode
  public String encode (String s) {

    // don't fill me in yet 

    return "";
  }

  // decode
  public String decode (String s) {

    // don't fill me in yet 

    return "";
  }

  public static void main (String[] args) {
    Huffman huff = new Huffman ();
    huff.buildFreqTab
      ("eeeeeeeeeeeeeeeeeeeeeeeeeeeeettttttttttnnnnnnnnniiiiissss");
    ft.print ();
  }
}






