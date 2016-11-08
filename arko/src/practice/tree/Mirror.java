package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class Mirror {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		binarySearchTree.insert(3);
		binarySearchTree.insert(5);
		System.out.println(binarySearchTree);
		System.out.println(binarySearchTree.inorder());
		binarySearchTree.root = mirror(binarySearchTree.root);
		System.out.println(binarySearchTree.inorder());
		System.out.println(binarySearchTree);
	}

	private static Node<Integer> mirror(Node<Integer> root) {
		if(root != null){
			mirror(root.left);
			mirror(root.right);
			Node<Integer> temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
}
