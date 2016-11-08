package practice.tree;

import practice.datastucture.BinarySearchTree;
import practice.datastucture.BinarySearchTree.Node;

public class IsBalanced {

	
	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(10);
		binarySearchTree.insert(5);
		binarySearchTree.insert(6);
		/*binarySearchTree.insert(1);
		binarySearchTree.insert(4);
		binarySearchTree.insert(8);
		binarySearchTree.insert(3);
		binarySearchTree.insert(7);
		binarySearchTree.insert(9);*/
		System.out.println(isBalanced(binarySearchTree.root, new Node<Integer>(0, null, null)));
	}
	private static boolean isBalanced(Node<Integer> root, Node<Integer> height) {
		/* lh --> Height of left subtree 
	     rh --> Height of right subtree */   
	  Node<Integer> lh = new Node<Integer>(0, null, null);  
	  Node<Integer> rh = new Node<Integer>(0, null, null);  
	 
	  /* l will be true if left subtree is balanced 
	    and r will be true if right subtree is balanced */
	  boolean l = false, r = false;
	     
	  if(root == null)
	  {
	    height.item = 0;
	     return true;
	  }
	 
	  /* Get the heights of left and right subtrees in lh and rh 
	    And store the returned values in l and r */   
	  l = isBalanced(root.left,lh);
	  r = isBalanced(root.right,rh);
	 
	  /* Height of current node is max of heights of left and 
	     right subtrees plus 1*/   
	  height.item = (lh.item > rh.item? lh.item: rh.item) + 1;
	     
	  /* If difference between heights of left and right 
	     subtrees is more than 2 then this node is not balanced
	     so return 0 */
	  if((lh.item - rh.item >= 2) || (rh.item - lh.item >= 2))
	    return false;
	     
	  /* If this node is balanced and left and right subtrees 
	    are balanced then return true */
	  else return l&&r;
	}
}
