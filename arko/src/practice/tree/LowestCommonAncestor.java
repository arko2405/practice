package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class LowestCommonAncestor {

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
		
		Node<Integer> node = lca(binarySearchTree.root,15,25);
		System.out.println(node);
	}

	private static Node<Integer> lca(Node<Integer> root, int i, int j) {
		if(root != null){
			if(root.item > i && root.item > j)
				return lca(root.left, i, j);
			else if(root.item < i && root.item < j)
				return lca(root.right, i, j);
			else
				return root;
		}
		return null;
	}
}
