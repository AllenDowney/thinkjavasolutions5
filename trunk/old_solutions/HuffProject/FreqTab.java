public class FreqTab {
  int[] array;

  // constructor
  public FreqTab () {
    array = new int [26];
  }

  // incrementFreq: finds the element of the array that corresponds
  // the the given character and increments it
  public void incrementFreq (char c) {
    int index = c - 'a';
    if (index < 0 || index > 25) return;
    array[index]++;
  }

  // getFreq: finds the element of the array that corresponds
  // the the given character and returns it
  public int getFreq (char c) {
    int index = c - 'a';
    if (index < 0 || index > 25) return -1;
    return (array[index]);
  }

  // print: prints the contents of the frequency table
  public void print () {
    for (int i=0; i<26; i++) {
      System.out.println (i + "\t" + array[i]);
    }
  }
}

  
