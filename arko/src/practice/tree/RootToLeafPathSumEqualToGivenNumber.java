package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class RootToLeafPathSumEqualToGivenNumber {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		binarySearchTree.insert(3);
		binarySearchTree.insert(5);
		binarySearchTree.insert(6);
		int sum=10;
		String s = "";
		boolean flag = rootToLeafPathsSumPresent(binarySearchTree.root, s,sum);
		System.out.println(flag);
	}
	
	private static boolean rootToLeafPathsSumPresent(Node<Integer> root, String s,
			int sum) {
		if (root != null) {
			if (root.left == null && root.right == null)
				sum= sum - root.item;
			     if(sum == 0){
				System.out.println(s + root.item);
				return true;
			     }
			else {
				s = s + root.item + " ";
				sum = sum - root.item;
				return rootToLeafPathsSumPresent(root.left, s,sum) || 
						rootToLeafPathsSumPresent(root.right, s,sum);
			}
		}
		return false;
	}
}
