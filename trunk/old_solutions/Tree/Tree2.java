import java.util.Stack;

public class Tree2 {
  int value;
  Tree left, right;

  public Tree2 (int value_, Tree left_, Tree right_) {
    value = value_;
    left = left_;
    right = right_;
  }

  public static void traverseTree (Tree root) {
    Stack stack = new Stack ();
    if (root != null) stack.push ((Object) root);
    Tree tree;
    int total = 0;

    while (!stack.empty()) {
      tree = (Tree) stack.pop ();
      System.out.println (tree.value);

      if (tree.right != null) stack.push ((Object) tree.right);
      if (tree.left != null) stack.push ((Object) tree.left);
    }
  }

  public static void main (String[] args) {
    Tree root = new Tree (3, null, null);
    Tree branch1 = new Tree (5, null, null);
    Tree branch2 = new Tree (7, null, null);
    Tree branch3 = new Tree (9, null, null);

    root.left = branch1;
    root.right = branch2;
    root.left.right = branch3;

    traverseTree (root);
  }
}

  
