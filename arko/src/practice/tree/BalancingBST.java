package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class BalancingBST {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(10);
		binarySearchTree.insert(5);
		binarySearchTree.insert(15);
		binarySearchTree.insert(25);
		binarySearchTree.insert(55);
		binarySearchTree.insert(60);
		binarySearchTree.insert(65);
		binarySearchTree.insert(75);
		binarySearchTree.insert(85);
		binarySearchTree.insert(95);
		

		System.out.println(binarySearchTree.levelorder());
		binarySearchTree.root = balanceBst(binarySearchTree.root);
		System.out.println(binarySearchTree.levelorder());
		System.out.println(binarySearchTree.inorder());
		System.out.println(binarySearchTree.preorder());

	}

	private static Node<Integer> balanceBst(Node<Integer> root) {
		if (root != null) {
			root.left = balanceBst(root.left);
			root.right = balanceBst(root.right);
			int balance = balance(root);
			if (balance > 1 && height(root.left.right) > height(root.left.left)) {
				root.left = leftRotate(root.left);
				root = rightRotate(root);
			} else if (balance > 1) {
				root = rightRotate(root);
			} else if (balance < -1
					&& height(root.right.left) > height(root.right.right)) {
				root.right = rightRotate(root.right);
				root = leftRotate(root);
			} else if (balance < -1) {
				root = leftRotate(root);
			}

			return root;
		}
		return root;
	}

	private static int balance(Node<Integer> root) {
		if (root == null)
			return 0;
		else
			return (height(root.left) - height(root.right));
	}

	private static int height(Node<Integer> root) {
		if (root == null)
			return 0;
		else
			return Math.max(height(root.left), height(root.right)) + 1;
	}

	private static Node<Integer> leftRotate(Node<Integer> root) {
		Node<Integer> x = root.right;
		Node<Integer> t = x.left;
		x.left = root;
		root.right = t;
		return x;
	}

	private static Node<Integer> rightRotate(Node<Integer> root) {
		Node<Integer> x = root.left;
		Node<Integer> t = x.right;
		x.right = root;
		root.left = t;
		return x;
	}
}
