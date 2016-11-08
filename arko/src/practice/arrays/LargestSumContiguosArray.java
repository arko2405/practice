package practice.arrays;

import java.util.Scanner;

public class LargestSumContiguosArray {
// 2 3 -2 1 -5 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int a[] =  new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			maxSubArraySum(a, a.length);
		}
	}

	private static void maxSubArraySum(int[] a, int length) {
		int max = a[0];
		int maxSoFar = a[0];
		int nonContiguousMaxSum = Math.max(0, a[0]);
		int nonContiguousMaxElement=a[0];
		for (int i = 1; i < a.length; i++) {
			maxSoFar = Math.max(a[i],maxSoFar + a[i]);
			max = Math.max(maxSoFar, max);
			nonContiguousMaxElement = Math.max(nonContiguousMaxElement, a[i]);
			nonContiguousMaxSum = Math.max(nonContiguousMaxSum,nonContiguousMaxSum + a[i]);
		}
		nonContiguousMaxSum = (nonContiguousMaxSum==0)?nonContiguousMaxElement:nonContiguousMaxSum;
		System.out.println(max + " "+nonContiguousMaxSum);
	}
}
