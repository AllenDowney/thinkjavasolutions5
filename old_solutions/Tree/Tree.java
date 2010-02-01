import java.util.Stack;

public class Tree {
  int value;
  Tree left, right;

  public Tree (int value_, Tree left_, Tree right_) {
    value = value_;
    left = left_;
    right = right_;
  }

  public static int totalTree (Tree tree) {
    if (tree == null) return 0;
    return tree.value + totalTree (tree.left) + totalTree (tree.right);
  }

  public static int totalTree2 (Tree root) {
    Stack stack = new Stack ();
    if (root != null) stack.push ((Object) root);
    Tree tree;
    int total = 0;

    while (!stack.empty()) {
      tree = (Tree) stack.pop ();
      // how do I know the popped item is not null?
      total += tree.value;
      if (tree.right != null) stack.push ((Object) tree.right);
      if (tree.left != null) stack.push ((Object) tree.left);
    }
    return total;
  }

  public static void main (String[] args) {
    Tree root = new Tree (3, null, null);
    Tree branch1 = new Tree (5, null, null);
    Tree branch2 = new Tree (7, null, null);
    Tree branch3 = new Tree (9, null, null);

    root.left = branch1;
    root.right = branch2;
    root.left.right = branch3;

    int x = totalTree2 (root);
    System.out.println (x);
  }
}

  
