package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class LevelOrderspiralForm {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(10);
		binarySearchTree.insert(20);
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(7);
		binarySearchTree.insert(6);
		binarySearchTree.insert(8);
		binarySearchTree.insert(15);
		binarySearchTree.insert(25);
		binarySearchTree.insert(1);
		int height = binarySearchTree.height();
		levelOrderSpiral(binarySearchTree.root,height);
	}

	private static void levelOrderSpiral(Node<Integer> root, int height) {
		for (int i = 1; i <= height; i++) {
			printlevel(root,i,i);
			System.out.println();
		}
	}

	private static void printlevel(Node<Integer> root, int i, int flag) {
		if(root != null){
			if(i == 1)
				System.out.print(root.item + " ");
			else if(flag%2 == 0){
				printlevel(root.right, i-1,flag);
				printlevel(root.left, i-1,flag);
			}
			else{
				printlevel(root.left, i-1,flag);
				printlevel(root.right, i-1,flag);
			}
		}
	}
}
