// Tree.java

public class Tree
{
	int datum;
	Tree left, right;
	
	public Tree (int datum, Tree left, Tree right)
	{
		this.datum = datum;
		this.left = left;  this.right = right;
	}

	public static int total (Tree tree)
	{
		if (tree == null) return 0;
		return tree.datum + total(tree.left) + total(tree.right);
	}

	public static void main(String args[])
	{
		Tree child1 = new Tree (3, null, null);
		Tree child2 = new Tree (5, null, null);
		Tree top = new Tree (7, child1, child2);
		
		System.out.println (total (top));
	}
}


