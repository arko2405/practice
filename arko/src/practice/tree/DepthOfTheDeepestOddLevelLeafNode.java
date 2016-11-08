package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class DepthOfTheDeepestOddLevelLeafNode {
	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(100);
		binarySearchTree.insert(50);
		binarySearchTree.insert(150);
		/*binarySearchTree.insert(60);
		binarySearchTree.insert(20);*/
		/*binarySearchTree.insert(110);*/
		binarySearchTree.insert(170);
		binarySearchTree.insert(160);
		binarySearchTree.insert(180);
		binarySearchTree.insert(155);
		binarySearchTree.insert(165);
		binarySearchTree.insert(168);
		binarySearchTree.insert(163);
		binarySearchTree.insert(152);
		System.out.println(depthOfDeepestOddLevelLeafNode(
				binarySearchTree.root, 1));
	}

	private static int depthOfDeepestOddLevelLeafNode(Node<Integer> root,
			int level) {
		if (root != null) {
			if (root.left == null && root.right == null && level % 2 != 0)
				return level;
			else
				return Math.max(
						depthOfDeepestOddLevelLeafNode(root.left, level + 1),
						depthOfDeepestOddLevelLeafNode(root.right, level + 1));
		}
		return 0;
	}
}