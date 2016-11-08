package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class ConvertBSTToBinaryTreeSumOfGreaterKeysAdded {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(10);
		binarySearchTree.insert(15);
		binarySearchTree.insert(5);
		binarySearchTree.insert(11);
		binarySearchTree.insert(20);
		System.out.println(binarySearchTree.levelorder());
		binarySearchTree.root = convertBST(binarySearchTree.root,0);
		System.out.println(binarySearchTree.levelorder());

	}


	private static Node<Integer> convertBST(Node<Integer> root , Integer item) {
		if(root == null)
			return null;
		
		root.right = convertBST(root.right,0);
		if(root.right != null){
			Node<Integer> node = root.right;
			while(node.left!=null)
				node = node.left;
			root.item = root.item + node.item;
			}
		root.item += item;
		root.left = convertBST(root.left, root.item);
		return root;
	}
}
