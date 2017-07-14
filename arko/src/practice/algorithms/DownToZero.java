package practice.algorithms;

import java.util.Scanner;

public class DownToZero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[1000001];
		arr = sieveOfEratosthenes(arr);
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		int start = 4;
		while (sc.hasNext()) {
			int q = sc.nextInt();
			while (q-- > 0) {
				int n = sc.nextInt();
				
				for (int i = start; i <= n; i++) {
					if (arr[i] != -1)
						arr[i] = arr[i - 1] + 1;
					else {
						arr[i] = arr[i - 1] + 1;
						for (int j = 2; j * j <= i; j++) {
							if (i % j == 0) {
								int bigFactor = Math.max(j, i / j);
								arr[i] = Math.min(arr[i], arr[bigFactor] + 1);
							}
						}
					}
				}
				System.out.println(arr[n]);
				start = Math.max(n+1, start);
			}

		}

	}

	static int[] sieveOfEratosthenes(int[] arr) {
		for (int p = 2; p * p < arr.length; p++) {
			if (arr[p] == 0) {
				for (int i = p * 2; i < arr.length; i += p)
					arr[i] = -1;
			}
		}
		return arr;
	}

}
/*
 * You are given queries. Each query consists of a single number . You can
 * perform operations on in each move. If , , we can change or decrease the
 * value of by .
 * 
 * Determine the minimum number of moves required to reduce the value of to .
 * 
 * Input Format
 * 
 * The first line contains the integer . The next lines each contain an integer,
 * .
 * 
 * Constraints
 * 
 * 
 * 
 * 
 * Output Format
 * 
 * Output lines. Each line containing the minimum number of moves required to
 * reduce the value of to .
 * 
 * Sample Input
 * 
 * 1 3 Sample Output
 * 
 * 3 Explanation
 * 
 * We only have one option that gives the minimum number of moves. Follow -> ->
 * -> . Hence, moves.
 */