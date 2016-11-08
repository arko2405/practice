package practice.advanced;

import java.util.Scanner;
import java.util.Stack;

public class FindMaximumIndexProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Integer n = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			Integer inp[] = new Integer[n+1];
			for (Integer i = 1; i <= n; i++) {
				inp[i]=sc.nextInt();
			}
			Integer left[] = new Integer[n+1];
			Integer right[] = new Integer[n+1];
			left[1]=0;
			right[n]=0;
			Long max = Long.MIN_VALUE;
			st.push(1);
			for (Integer i = 2; i <= n; i++) {
				while(!st.isEmpty() && inp[i]>=inp[st.peek()]){
					    st.pop();
				}
				left[i]=st.isEmpty()?0:st.peek();
				st.push(i);
			}
			st.clear();
			st.push(n);
			for (Integer i = n-1; i >= 1; i--) {
				while(!st.isEmpty() && inp[i]>=inp[st.peek()]){
					    st.pop();
				}
				right[i]=st.isEmpty()?0:st.peek();
				st.push(i);
			}
			for (int i = 1; i <= n; i++) {
				Long l = new Long(left[i].toString());
				Long r = new Long(right[i].toString());
				max = Math.max(max, l*r);
			}
			System.out.println(max);
		}

	
	}

}
/*

You are given a list of  numbers . For each element at position  (), we define and  as: 
 = closest index j such that j < i and . If no such j exists then  = 0. 
 = closest index k such that k > i and . If no such k exists then  = 0.

We define  =  * . You need to find out the maximum  among all i.

Input Format

The first line contains an integer , the number of integers. The next line contains the  integers describing the list a[1..N].

Constraints

 


Output Format

Output the maximum  among all indices from  to .

Sample Input

5
5 4 3 4 5
Sample Output

8
Explanation

We can compute the following:

 
 
 
 


The largest of these is 8, so it is the answer.

*/