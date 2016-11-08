package practice.algorithms;

import java.util.Scanner;

public class EditDistance  {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String s1 = input.next();
		String s2 = input.next();
		System.out.println(editDistance(s1, s2));
	}

	public static int editDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int distance[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			distance[i][0] = i;
		}
		for (int j = 0; j < n + 1; j++) {
			distance[0][j] = j;
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				distance[i][j] = Math.min(
						distance[i - 1][j - 1]
								+ ((s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0
										: 1),
						Math.min(distance[i - 1][j] + 1, distance[i][j - 1]+1));
			}
		}
		return distance[m][n];
	}
}
