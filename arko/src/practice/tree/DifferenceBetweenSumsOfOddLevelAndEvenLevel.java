package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class DifferenceBetweenSumsOfOddLevelAndEvenLevel {
	static int sumOdd = 0;
	static int sumEven = 0;

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
		differenceBetweenSumsOfOddLevelAndEvenLevel(binarySearchTree.root, 1);
		System.out.println(sumOdd - sumEven);
	}

	private static void differenceBetweenSumsOfOddLevelAndEvenLevel(
			Node<Integer> root, int level) {
		if (root != null) {
			if (level % 2 != 0)
				sumOdd += root.item;
			else
				sumEven += root.item;

			differenceBetweenSumsOfOddLevelAndEvenLevel(root.left, level + 1);
			differenceBetweenSumsOfOddLevelAndEvenLevel(root.right, level + 1);
		}
		
	}

}
