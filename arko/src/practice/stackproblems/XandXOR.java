package practice.stackproblems;

import java.util.Scanner;
import java.util.Stack;

public class XandXOR {
	/// 9 6 3 5 2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			int inp[] = new int[n];
			for (int i = 0; i < inp.length; i++) {
				inp[i] = sc.nextInt();
			}
			int max = Integer.MIN_VALUE;
			st.push(0);
			for (int i = 1; i < n; i++) {
				if (inp[i] > inp[st.peek()]) {
					max = Math.max(max, inp[i] ^ inp[st.peek()]);
				} else {
					int curMax = 0;
					while (!st.isEmpty() && inp[i] <= inp[st.peek()]) {
						curMax = Math.max(curMax, inp[i] ^ inp[st.peek()]);
						st.pop();
					}
					if(!st.empty())
					curMax = Math.max(curMax, inp[i] ^ inp[st.peek()]);
					max = Math.max(max, curMax);
				}
				st.push(i);
			}
			System.out.println(max);
		}
		
	}

}
