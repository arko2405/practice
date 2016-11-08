package practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import practice.datastucture.BinarySearchTree.Node;

public class SwapNode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Node arr[] =  new Node[n+1];
			for (int i = 1; i <= n; i++) {
				Node node = new Node();
				node.data=i;
				arr[i]=node;
			}
			for (int i = 1; i <= n; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				arr[i].left=(l!=-1)?arr[l]:null;
				arr[i].right=(r!=-1)?arr[r]:null;
			}
			int q = sc.nextInt();
			while(q-->0){
				int k = sc.nextInt();
				int height = height(arr[1]);
				for (int i = k; i <= height; i=i+k) {
					swap(arr[1],i);
				}
				inorder(arr[1]);
				if(q>0)
					System.out.println();
			}
		}
	}
	
	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data+ " ");
			inorder(root.right);
		}
	}
	
	private static void swap(Node root, int level) {
		if(root != null){
			if(level == 1){
				Node temp = root.right;
				root.right = root.left;
				root.left = temp;
			}
			else {
				swap(root.right, level-1);
				swap(root.left, level-1);
			}
		}
	}
	
	private static int height(Node root) {
		if (root != null) {
			return 1 + Math.max(height(root.left), height(root.right));
		}
		return 0;
	}
	
	public static class Node{
		public int data;
		public Node left;
		public Node right;
	}
}
/*
A binary tree is a tree which is characterized by any one of the following properties:

It can be an empty (null).
It contains a root node and two subtrees, left subtree and right subtree. These subtrees are also binary tree.
Inorder traversal is performed as

Traverse the left subtree.
Visit root (print it).
Traverse the right subtree.
(For an Inorder traversal, start from the root and keep visiting the left subtree recursively until you reach the leaf,then you print the node at which you are and then you visit the right subtree.)

We define depth of a node as follow:

Root node is at depth 1.
If the depth of parent node is d, then the depth of current node wll be d+1.
Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, then after swapping left subtree will be R and right subtree L.

Eg. In the following tree, we swap children of node 1.

                                Depth
    1               1            [1]
   / \             / \
  2   3     ->    3   2          [2]
   \   \           \   \
    4   5           5   4        [3]
Inorder traversal of left tree is 2 4 1 3 5 and of right tree is 3 5 1 2 4.

Swap operation: Given a tree and a integer, K, we have to swap the subtrees of all the nodes who are at depth h, where h ∈ [K, 2K, 3K,...].

You are given a tree of N nodes where nodes are indexed from [1..N] and it is rooted at 1. You have to perform T swap operations on it, and after each swap operation print the inorder traversal of the current state of the tree.

Input Format 
First line of input contains N, number of nodes in tree. Then N lines follow. Here each of ith line (1 <= i <= N) contains two integers, a b, where a is the index of left child, and b is the index of right child of ith node. -1 is used to represent null node. 
Next line contain an integer, T. Then again T lines follows. Each of these line contains an integer K.

Output Format 
For each K, perform swap operation as mentioned above and print the inorder traversal of the current state of tree.

Constraints 
1 <= N <= 1024 
1 <= T <= 100 
1 <= K <= N 
Either a = -1 or 2 <= a <= N 
Either b = -1 or 2 <= b <= N 
Index of (non-null) child will always be greater than that of parent.

Sample Input #00

3
2 3
-1 -1
-1 -1
2
1
1
Sample Output #00

3 1 2
2 1 3

*/