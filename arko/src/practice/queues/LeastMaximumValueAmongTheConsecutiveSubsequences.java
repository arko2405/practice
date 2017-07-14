package practice.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeastMaximumValueAmongTheConsecutiveSubsequences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int q =sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			while(q-->0){
				int d = sc.nextInt();
				Queue<Integer> qu = new LinkedList<>();
				int minMax=Integer.MAX_VALUE;
				int currMax=Integer.MIN_VALUE;
				for (int i = 0; i < d; i++) {
					qu.add(arr[i]);
					currMax = Math.max(currMax, arr[i]);
				}
				minMax = Math.min(currMax, minMax);
				for (int i = d; i < n; i++) {
					if(arr[i]>=currMax){
						qu.poll();
						qu.add(arr[i]);
						currMax =arr[i];
					}
					else if (qu.peek() == currMax){
						qu.poll();
						qu.add(arr[i]);
						currMax = Math.min(currMax, max(qu));
						minMax = Math.min(currMax, minMax);
					}
					else{
						qu.poll();
						qu.add(arr[i]);
					}
				}
				System.out.println(minMax);
			}
		}

	}

	private static int max(Queue<Integer> qu) {
		int max = Integer.MIN_VALUE;
		Queue<Integer> qq = new LinkedList<>();
		qq.addAll(qu);
		for (int i = 0; i < qu.size(); i++) {
			max = Math.max(max,qq.poll());
		}
		return max;
	}

}
/*
You are given a sequence  that consists of  integers. There are  queries. For each query, you will be given an integer , and you need to calculate this equation:

CodeCogsEqn (1).gif

Input Format

The first line consists of two space separated integers:  and . 
The next line consists of  space separated integers: , ,...,  
The following  lines contains a single integer: .

Constraints 
 
 
 
 

Output Format

Output  lines, each denoting the answer to the respective query.

Sample Input

5 5
1 2 3 4 5
1
2
3
4
5
Sample Output

1
2
3
4
5
Explanation

Each prefix has the least maximum value among the consecutive subsequences that have the same size.

*/