package practice.algorithms;

import java.util.Scanner;

public class LongestPalindromicSubSeq {

	//static String seq = "abcdmadamdfghabcdedcgsprinklrlk";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
		longestPaindrome(sc.next());
		}
	}

	private static void longestPaindrome(String seq) {
		int length = seq.length();
		boolean isPalindrome[][] = new boolean[length][length];
		int max = 1;
		int start = 0;
		for (int i = 0; i < length; i++) {
			isPalindrome[i][i] = true;
		}
		for (int i = 0; i < length - 1; i++) {
			if (seq.charAt(i) == seq.charAt(i + 1)) {
				isPalindrome[i][i + 1] = true;
				start = i;
				max = 2;
			}
		}
		for (int l = 2; l < length; l++) {
			for (int i = 0; i < length - l; i++) {
				int j = i + l;
				if (seq.charAt(i) == seq.charAt(j)
						&& isPalindrome[i + 1][j - 1]) {
					isPalindrome[i][j] = true;
					if (l + 1 > max) {
						max = l + 1;
						start = i;
					}
				}
			}
		}
		System.out.println(seq.substring(start, start+max));
	}
}
