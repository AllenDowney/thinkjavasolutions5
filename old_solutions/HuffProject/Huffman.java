public class Huffman {

  // the frequency table contains the frequencies for each
  // letter in the sample
  FreqTab ft;
  HuffTree ht;

  // constructor
  public Huffman () {
    ft = new FreqTab ();
  }

  // buildFreqTab: traverses the sample string and invokes
  // incrementFreq to count the number of times each letter
  // appears

  public void buildFreqTab (String sample) {
    for (int i=0; i<sample.length(); i++) {
      ft.incrementFreq (sample.charAt (i));
    }
    ft.print ();
  }

  // buildHuffTree
  public void buildHuffTree () {
  }

  // buildCodeTab
  public void buildCodeTab () {
  }

  // encode
  public String encode (String s) {
    return "";
  }

  // decode
  public String decode (String s) {
    return "";
  }

  public static void main (String[] args) {
    Huffman huff = new Huffman ();
    huff.buildFreqTab
      ("eeeeeeeeeeeeeeeeeeeeeeeeeeeeettttttttttnnnnnnnnniiiiissss");
  }
}






