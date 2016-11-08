package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;
import practice.datastucture.QueueArray;

public class TreeHeightIterative {

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
		System.out.println(iterativeHeight(binarySearchTree.root));
	}

	private static int iterativeHeight(Node<Integer> root) {
		if (root == null)
			return 0;

		QueueArray<Node<Integer>> queue = new QueueArray<BinarySearchTree.Node<Integer>>();
		queue.enqueue(root);
		int height = 0;
		while (true) {
			int numOfNodes = queue.size();
			if (numOfNodes == 0)
				return height;
			height++;
			while (numOfNodes > 0) {
				Node<Integer> node = queue.dequeue();
				if (node.left != null)
					queue.enqueue(node.left);
				if (node.right != null)
					queue.enqueue(node.right);
				numOfNodes--;
			}
		}
	}
}
