package practice.advanced;

import java.util.Scanner;

public class SumOfMaximumsRecursive {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Integer n = sc.nextInt();
			Integer m = sc.nextInt();
			long inp[] = new long[n+1];
			for (int i = 1; i <= n; i++) {
				inp[i]=sc.nextLong();
			}
			while(m-->0){
				int l = sc.nextInt();
				int r = sc.nextInt();
				long maxSum = maxSum(inp,l,r);
				System.out.println(maxSum);
			}
		}
	

	}

	private static long maxSum(long[] inp, int l, int r) {
		if(l==r)
			return inp[l];
		if(l>r)
			return 0;
		return maxSum(inp, l, r-1)+maxSum(inp, l+1, r)-maxSum(inp, l+1, r-1)+max(inp,l,r);
	}

	private static long max(long[] inp, int l, int r) {
		long m = Long.MIN_VALUE;
		for (int i = l; i <= r; i++) {
			m = m>inp[i]?m:inp[i];
		}
		return m;
	}

}
