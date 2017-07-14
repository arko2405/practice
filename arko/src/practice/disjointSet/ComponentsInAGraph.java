package practice.disjointSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ComponentsInAGraph {

	public static void main(String[] args) {

		//findMaxMinSizeDisjointSetUsingHashSet();
		findMaxMinSizeDisjointSetUsingArray();

	}

	private static void findMaxMinSizeDisjointSetUsingArray() {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int parents[] = new int[2*n+1];
			int sizeOfDisjoint[] = new int[n+1];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			while (n-- > 0) {
				int g = sc.nextInt();
				int b= sc.nextInt();
				if(parents[g] == 0){
					parents[g] = g;
					sizeOfDisjoint[g]++;
					}
		        if(parents[b] == 0){ 
		        	parents[b] = parents[g];
		        	sizeOfDisjoint[parents[g]]++;
		        	}
		        if(parents[g] != parents[b]){
		            int low = Math.min(parents[g], parents[b]);
		            int high = Math.max(parents[g], parents[b]);
		            for(int i=0; i<parents.length; i++){
		                if(parents[i] == high){
		                    parents[i] = low;
		                    sizeOfDisjoint[low]++;
		                    sizeOfDisjoint[high]--;
		                }
		            }
		        }
		        
			}
			for (int i = 0; i < sizeOfDisjoint.length; i++) {
				if(sizeOfDisjoint[i]>0){
					max = Math.max(max, sizeOfDisjoint[i]);
					min = Math.min(min, sizeOfDisjoint[i]);
				}
				
			}
			System.out.println(min+" "+max);
			
		}
		
	}

	private static void findMaxMinSizeDisjointSetUsingHashSet() {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Map<Integer, Set<Integer>> disjointSet = new HashMap<>();
			while (n-- > 0) {
				int g = sc.nextInt();
				int b= sc.nextInt();
				int gParent = find(disjointSet,g);
				int bParent = find(disjointSet,b);
				mergeDisjoint(g,gParent,b,bParent,disjointSet);
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (Entry<Integer, Set<Integer>> entry : disjointSet.entrySet()) {
				
					max = Math.max(max, entry.getValue().size());
					min = Math.min(min, entry.getValue().size());
			}
			System.out.println(min+" "+max);
			
		}
	}

	private static void mergeDisjoint(int g, int gParent, int b, int bParent, Map<Integer, Set<Integer>> disjointSet) {
		if(gParent==0 && bParent==0){
			Set<Integer> set =  new HashSet<>();
			set.add(g);
			set.add(b);
			disjointSet.put(g, set);
		}
		else if(gParent==bParent)
			return;
		else if(bParent==0){
			disjointSet.get(gParent).add(b);
		}
		else if(gParent==0){
			disjointSet.get(bParent).add(g);
		}
		else{
			int min = Math.min(gParent, bParent);
			int max = Math.max(gParent, bParent);
			disjointSet.get(min).addAll(disjointSet.get(max));
			disjointSet.remove(max);
		}
		
	}

	private static int find(Map<Integer, Set<Integer>> disjointSet, int g) {
		for (Entry<Integer, Set<Integer>> entry : disjointSet.entrySet()) {
			if(entry.getValue().contains(g))
				return entry.getKey();
		}
		return 0;
	}

}
/*

There are  values to represent nodes in a graph. They are divided into two sets  and . Each set has exactly  values. Set  is represent by .  can contain any value between  to (inclusive). Set  is represented by .  can contain any value between  to (inclusive). Same value can be chosen any number of times.

Here  represents the edges of the graph.

Your task is to print the number of vertices in the smallest and the largest connected components of the graph.

Note Single nodes should not be considered in the answer.

For more clarity look at the following figure.

Alt text

For the above graph smallest connected component is 7 and largest connected component is 17.

Input Format

First line contains an integer . 
Each of the next  lines contain two space-separated integers,  line contains  and .

Constraints




Output Format

Print two space separated integers, the number of vertices in the smallest and the largest components.

Sample Input

5
1 6 
2 7
3 8
4 9
2 6
Sample Output

2 4
Explanation

The number of vertices in the smallest connected component in the graph is  i.e. either  or . 
The number of vertices in the largest connected component in the graph is  i.e. .

*/


