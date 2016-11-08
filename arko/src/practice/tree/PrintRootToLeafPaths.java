package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class PrintRootToLeafPaths {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		binarySearchTree.insert(3);
		binarySearchTree.insert(5);
		binarySearchTree.insert(6);
		
		String s = "";
		printRootToLeafPaths(binarySearchTree.root, s);
	}

	private static void printRootToLeafPaths(Node<Integer> root, String s) {
		if (root != null) {
			if (root.left == null && root.right == null)
				System.out.println(s + root.item);
			else {
				s = s + root.item + " ";
				printRootToLeafPaths(root.left, s);
				printRootToLeafPaths(root.right, s);
			}
		}
	}
}
