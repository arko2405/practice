package practice.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;import org.omg.CORBA.portable.ValueInputStream;

public class LazyWhiteFalcon_Tree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Integer n = sc.nextInt();
			Integer q = sc.nextInt();
			Node tree[] = new Node[n];
			Map<Integer, Integer> root = new HashMap<>();
			Map<Integer, Integer> child = new HashMap<>();
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				int b =sc.nextInt();
				if(tree[a]==null)
					tree[a] = new Node(0, null);
				if(tree[b]==null)
					tree[b]= new Node(0, tree[a]);
				tree[b].parent = tree[a];
				if(child.containsKey(b)){
					System.out.println("More than 1 parent : for "+b + " =   "+ child.get(b) + "  " + a);
				}
				else
					child.put(b, a);
				if(!child.containsKey(a))
					root.put(a, b);
				if(root.containsKey(b))
					root.remove(b);
				
			}
			for (int i = 0; i < q; i++) {
				int x = sc.nextInt();
				if(x==1){
					tree[sc.nextInt()].value = sc.nextInt();
				}
				if(x==2){
					int a = sc.nextInt();
					int b =sc.nextInt();
					int max = Math.max(a, b);
					int min = Math.min(a, b);
					int sum1 = findSumTillRoot(tree[min],0,0);
					int sum2 = findSumTillRoot(tree[max], 0 , 0);
					findSumTillRoot(tree[min],0,0);
					findSumTillRoot(tree[max],0,0);
					System.out.println(sum1+sum2);
				}
			}
		}

	}
	
	private static Integer findSumTillRoot(Node node , int sumTillNow , int noOfVisitedNode) {
		 if(node == null)
			 return sumTillNow;
		if(node.visited==true ){
			if(noOfVisitedNode == 0){
				node.visited = false;
				return findSumTillRoot(node.parent, sumTillNow, noOfVisitedNode+1);
			}
			else{
				node.visited=false;
				sumTillNow = sumTillNow-node.value;
				return findSumTillRoot(node.parent, sumTillNow, noOfVisitedNode+1);
			}
		}
		else if(node.parent==null){
			node.visited = true;
			return sumTillNow+node.value;
		}
		else{
			node.visited = true;
			return findSumTillRoot(node.parent, sumTillNow+node.value,0);
		}
	}

	public static class Node{
		public int value;
		public Node parent;
		public Boolean visited;
		public Node(int value, Node parent) {
			this.value = value;
			this.parent = parent;
			this.visited = false;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", parent=" + parent + ", visited=" + visited + "]";
		}
		
	}

}
/*

White Falcon just solved the data structure problem below using heavy-light decomposition. Can you help her find a new solution that doesn't require implementing any fancy techniques?

There are  types of query operations that can be performed on a tree:

1 u x: Assign  as the value of node .
2 u v: Print the sum of the node values in the unique path from node  to node .
Given a tree with  nodes where each node's value is initially , execute  queries.

Input Format

The first line contains  space-separated integers,  and , respectively. 
The  subsequent lines each contain  space-separated integers describing an undirected edge in the tree. 
Each of the  subsequent lines contains a query you must execute.

Constraints



It is guaranteed that the input describes a connected tree with  nodes.
Nodes are enumerated with -based indexing.
Output Format

For each type- query, print its integer result on a new line.

Sample Input

3 3
0 1
1 2
1 0 1
1 1 2
2 0 2
Sample Output

3
Explanation

Lazy White Falcon Expl.png

After the first  queries, the value of node  and the value of node . The third query requires us to print the sum of the node values in the path from nodes  to , which is . Thus, we print  on a new line.

*/