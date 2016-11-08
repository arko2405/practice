package practice.tree;

import practice.datastucture.BinarySearchTree;

public class TreeFromInorderPreOrder {
	static BinarySearchTree<Integer> builtTree = new BinarySearchTree<Integer>();

	public static void main(String[] args) {
		/*BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(5);
		binarySearchTree.insert(2);
		binarySearchTree.insert(6);
		binarySearchTree.insert(1);
		binarySearchTree.insert(4);
		binarySearchTree.insert(8);
		binarySearchTree.insert(3);
		binarySearchTree.insert(7);
		binarySearchTree.insert(9);
		System.out.println(binarySearchTree.inorder());
		System.out.println(binarySearchTree.preorder());
		System.out.println(binarySearchTree);*/
		int inOrder[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int preOrder[] = { 5, 2, 1, 4, 3, 6, 8, 7, 9 };
		treeFromInorderPreOrder(inOrder, preOrder, 0, 0,
				inOrder.length - 1, preOrder.length - 1);
		System.out.println(builtTree);
	}

	private static void treeFromInorderPreOrder(
			int[] inOrder, int[] preOrder, int startInorder, int startPreorder,
			int endInorder, int endPreorder) {
		if (endInorder > startInorder) {
			builtTree.insert(preOrder[startPreorder]);
			int index = search(inOrder, preOrder[startPreorder], startInorder,
					endInorder);
			 treeFromInorderPreOrder(inOrder, preOrder, startInorder,
					startPreorder+1, index-1,startPreorder + index-startInorder);
			 treeFromInorderPreOrder(inOrder, preOrder, index+1,
					 startPreorder + index-startInorder+1, endInorder, endPreorder);
		}
		if(startInorder == endInorder)
			builtTree.insert(preOrder[startPreorder]);
		
	}

	private static int search(int[] inOrder, int item, int startInorder,
			int endInorder) {
		for (int i = startInorder; i <= inOrder.length; i++) {
			if (inOrder[i] == item)
				return i;
		}
		return 0;
	}
}
