package practice.tree;

import practice.datastucture.BinarySearchTree.Node;

public class IsomorpicTrees {

	public static void main(String[] args) {
		Node<Integer> g = new Node<Integer>(8, null, null); 
		Node<Integer> f = new Node<Integer>(7, null, null); 
		Node<Integer> e = new Node<Integer>(6, null, null); 
		Node<Integer> d = new Node<Integer>(5, f, g); 
		Node<Integer> c = new Node<Integer>(4, null, null); 
		Node<Integer> b = new Node<Integer>(3, e, null); 
		Node<Integer> a = new Node<Integer>(2, c, d); 
		Node<Integer> tree1 = new Node<Integer>(1, a, b); 
		
		Node<Integer> g2 = new Node<Integer>(8, null, null); 
		Node<Integer> f2 = new Node<Integer>(7, null, null); 
		Node<Integer> e2 = new Node<Integer>(6, null, null); 
		Node<Integer> d2 = new Node<Integer>(5, g2, f2); 
		Node<Integer> c2= new Node<Integer>(4, null, null); 
		Node<Integer> b2 = new Node<Integer>(3, null, e2); 
		Node<Integer> a2 = new Node<Integer>(2, c2, d2); 
		Node<Integer> tree2 = new Node<Integer>(1, b2, a2); 
		System.out.println(isIsomorphic(tree1,tree2));
	}

	private static boolean isIsomorphic(Node<Integer> tree1, Node<Integer> tree2) {
		if(tree1 == null && tree2 == null)
			return true;
		if(tree1 == null || tree2 == null)
			return false;
		if(tree1.item != tree2.item)
			return false;
		return ((isIsomorphic(tree1.left, tree2.left) && isIsomorphic(tree1.right, tree2.right))
				|| (isIsomorphic(tree1.left, tree2.right) && isIsomorphic(tree1.right, tree2.left)));
	}
}
