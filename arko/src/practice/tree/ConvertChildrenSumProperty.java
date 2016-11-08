package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class ConvertChildrenSumProperty {

	public static void main(String[] args) {
		Node<Integer> f = new Node<Integer>(30, null, null);
		Node<Integer> e = new Node<Integer>(1, null, null);
		Node<Integer> d = new Node<Integer>(5, null,null);
		Node<Integer> c = new Node<Integer>(3, null, null);
		Node<Integer> b = new Node<Integer>(2, e, f);
		Node<Integer> a = new Node<Integer>(7, c, d);
		Node<Integer> root = new Node<Integer>(50, a, b);
		
		printInorder(root);
		System.out.println();
		root = convertToChildrenSumProperty(root);
		printInorder(root);
	}

	private static Node<Integer> convertToChildrenSumProperty(Node<Integer> root) {
		if(root==null || (root.left == null && root.right == null))
			return root;
		root.left = convertToChildrenSumProperty(root.left);
		root.right = convertToChildrenSumProperty(root.right);
		int leftData = 0 , rightData = 0;
		if(root.left != null)
			leftData = root.left.item;
		if(root.right != null)
			rightData = root.right.item;
		int diff = leftData + rightData - root.item;
		if(diff > 0)
			root.item += diff;
		else if(diff < 0)
			root = increment(root,0-diff);
		return root;
	}

	private static Node<Integer> increment(Node<Integer> root, int diff) {
		if(root.left != null){
			root.left.item += diff;
			increment(root.left, diff);
		}
		else if(root.right != null){
			root.right.item += diff;
			increment(root.right, diff);
		}
	    return root;
	}

	private static void printInorder(Node<Integer> root) {
		if(root != null){
			printInorder(root.left);
			System.out.print(root.item + " ");
			printInorder(root.right);
		}
	}
}
