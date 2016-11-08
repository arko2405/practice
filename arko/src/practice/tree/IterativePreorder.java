package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;
import practice.datastucture.StackArray;

public class IterativePreorder {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(5);
		binarySearchTree.insert(2);
		binarySearchTree.insert(6);
		binarySearchTree.insert(1);
		binarySearchTree.insert(4);
		binarySearchTree.insert(8);
		binarySearchTree.insert(3);
		binarySearchTree.insert(7);
		binarySearchTree.insert(9);
		System.out.println(binarySearchTree.preorder());
		iterativePreorder(binarySearchTree.root);
		System.out.println();
		System.out.println(binarySearchTree.postorder());
		iterativePostorder(binarySearchTree.root);
		System.out.println();
		iterativePostorderSingleStack(binarySearchTree.root);
	}

	private static void iterativePostorderSingleStack(Node<Integer> root) {
		if (root != null) {
			StackArray<Node<Integer>> array = new StackArray<Node<Integer>>();
			array.push(root);
			while (!array.isEmpty()) {
				Node<Integer> node = array.pop();
				if (node.left == null && node.right == null)
					System.out.print(node.item + " ");
				else {
					Node<Integer> left = node.left;
					Node<Integer> right = node.right;
					node.left = null;
					node.right = null;
					array.push(node);
					if (right != null)
						array.push(right);
					if (left != null)
						array.push(left);
				}
			}
		}
	}

	private static void iterativePostorder(Node<Integer> root) {
		StackArray<Node<Integer>> array = new StackArray<Node<Integer>>();
		StackArray<Node<Integer>> array2 = new StackArray<Node<Integer>>();
		if (root != null) {
			array.push(root);
			while (!array.isEmpty()) {
				Node<Integer> node = array.pop();
				array2.push(node);
				if (node.left != null)
					array.push(node.left);
				if (node.right != null)
					array.push(node.right);
			}
		}
		while (!array2.isEmpty())
			System.out.print(array2.pop().item + " ");
	}

	private static void iterativePreorder(Node<Integer> root) {
		if (root != null) {
			StackArray<Node<Integer>> array = new StackArray<Node<Integer>>();
			array.push(root);
			while (!array.isEmpty()) {
				Node<Integer> node = array.pop();
				System.out.print(node.item + " ");
				if (node.right != null)
					array.push(node.right);
				if (node.left != null)
					array.push(node.left);
			}
		}
	}
}
