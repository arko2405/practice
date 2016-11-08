package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;
import practice.datastucture.StackArray;

public class IterativeInorder {

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
		System.out.println(binarySearchTree.inorder());
		iterativeInorder(binarySearchTree.root);
	}

	private static void iterativeInorder(Node<Integer> root) {
		if(root != null){
			StackArray<Node<Integer>> array = new StackArray<Node<Integer>>();
			array.push(root);
			while(!array.isEmpty()){
				Node<Integer> node = array.pop();
				if(node.left == null && node.right==null)
					System.out.print(node.item + " ");
				else{
					Node<Integer> left = node.left;
					Node<Integer> right = node.right;
					node.left = null;
					node.right = null;
					if(right != null)
						array.push(right);
					array.push(node);
					if(left != null)
						array.push(left);
				}
			}
		}
	}
}
