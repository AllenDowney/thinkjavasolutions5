public class CodeTab {
  Code[] array;

  public CodeTab () {
    array = new Code [26];
  }

  public void addEntry (char c, Code code) {
    int index = c - 'a';
    if (index < 0 || index > 25) return;
    array[index] = code;
    System.out.println (c + "\t" + code);
  }

  public Code getEntry (char c) {
    int index = c - 'a';
    if (index < 0 || index > 25) return null;
    return array[index];
  }

  public void print () {
    for (int i=0; i<26; i++) {
      System.out.println (i + "\t" + array[i]);
    }
  }
}

  
