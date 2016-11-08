package practice.algorithms;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class LargestIndependentSetProblem {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(10);
		binarySearchTree.insert(2);
		binarySearchTree.insert(30);
		binarySearchTree.insert(1);
		binarySearchTree.insert(5);
		binarySearchTree.insert(6);
		binarySearchTree.insert(7);
		binarySearchTree.insert(60);
		
		System.out.println(largestIndependentSet(binarySearchTree.root));
	}

	private static int largestIndependentSet(
			Node<Integer> root) {
		if(root == null)
			return 0;
		int sizeExcluding = largestIndependentSet(root.left) + largestIndependentSet(root.right);
		int sizeIncluding = 1;
		if(root.left !=null){
			sizeIncluding += largestIndependentSet(root.left.left)+largestIndependentSet(root.left.right);
		}
		if(root.right !=null){
			sizeIncluding += largestIndependentSet(root.right.left)+largestIndependentSet(root.right.right);
		}
		return Math.max(sizeExcluding, sizeIncluding);
	}
}
