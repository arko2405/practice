package practice.tree;

import practice.datastucture.BinarySearchTree.Node;

public class CheckGivenBinaryTreeIsSumTree {

	public static void main(String[] args) {
		Node<Integer> f = new Node<Integer>(4, null, null);
		Node<Integer> e = new Node<Integer>(6, null, null);
		Node<Integer> d = new Node<Integer>(3, null,null);
		Node<Integer> c = new Node<Integer>(3, null, d);
		Node<Integer> b = new Node<Integer>(10, e, f);
		Node<Integer> root = new Node<Integer>(26, b, c);
		
		boolean flag = isSumTree(root);
		System.out.println(flag);
	}

	private static boolean isSumTree(Node<Integer> root) {
		if(root == null || (root.left==null && root.right==null))
			return true;
		else if(isSumTree(root.left) && isSumTree(root.right)){
			int ls,rs;
			if(root.left == null)
				ls=0;
			else if(root.left.left == null && root.left.right == null)
				ls = root.left.item;
			else
				ls = 2 * root.left.item;
			
			if(root.right == null)
				rs=0;
			else if(root.right.left == null && root.right.right == null)
				rs = root.right.item;
			else
				rs = 2 * root.right.item;
			
			if(root.item == (ls + rs))
				return true;
		}
		return false;
	}
}
