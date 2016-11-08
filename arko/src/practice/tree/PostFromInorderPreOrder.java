package practice.tree;

public class PostFromInorderPreOrder {
	
	static int postOrder[] = new int[9];
	public static void main(String[] args) {
		
		int inOrder[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int preOrder[] = { 5, 2, 1, 4, 3, 6, 8, 7, 9 };
		postOrderFromInorderPreOrder(inOrder, preOrder, 0, 0,
				inOrder.length - 1, preOrder.length - 1,0,postOrder.length-1);
		for (int i = 0; i < postOrder.length; i++) {
			System.out.print(postOrder[i]+" ");
		}
	}

	private static void postOrderFromInorderPreOrder(
			int[] inOrder, int[] preOrder, int startInorder, int startPreorder,
			int endInorder, int endPreorder,int postStart,int postEnd) {
		if (endInorder > startInorder) {
			postOrder[postEnd]= preOrder[startPreorder];
			int index = search(inOrder, preOrder[startPreorder], startInorder,
					endInorder);
			postOrderFromInorderPreOrder(inOrder, preOrder, startInorder,
					startPreorder+1, index-1,startPreorder + index-startInorder,
					postStart,postStart + index-startInorder-1);
			postOrderFromInorderPreOrder(inOrder, preOrder, index+1,
					 startPreorder + index-startInorder+1, endInorder, endPreorder,
					 postStart + index-startInorder,postEnd-1);
		}
		if(startInorder == endInorder)
			postOrder[postEnd]= preOrder[startPreorder];
		
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

