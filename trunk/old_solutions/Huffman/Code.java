public class Code {
  boolean[] path;

  // constructor: note that we make a copy of the path provided
  // as an argument, so the caller is free to modify the array
  // after the constructor completes.

  public Code (boolean[] path_, int length) {
    path = new boolean[length];
    for (int i=0; i<length; i++) {
      path[i] = path_[i];
    }
  }

  public String toString () {
    String s = "";
    for (int i=0; i<path.length; i++) {
      if (path[i]) {
	s = s + "1";
      } else {
	s = s + "0";
      }
    }
    return s;
  }
}



