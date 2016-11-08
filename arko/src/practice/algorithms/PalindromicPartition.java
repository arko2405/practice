package practice.algorithms;

public class PalindromicPartition {

	static String seq = "ababbbabbababa";

	public static void main(String[] args) {
		System.out.println(noOfPartitions());
	}

	private static int noOfPartitions() {
		int length = seq.length();
		int matrix[][] = new int[length][length];
		boolean isPalindrome[][] = new boolean[length][length];
		for (int i = 0; i < isPalindrome.length; i++) {
			isPalindrome[i][i] = true;
			matrix[i][i] = 0;
		}
		for (int l = 1; l < length; l++) {
			for (int i = 0; i < length - l; i++) {
				int j = i + l;
				if (l == 2)
					isPalindrome[i][j] = (seq.charAt(i) == seq.charAt(j));
				else
					isPalindrome[i][j] = (seq.charAt(i) == seq.charAt(j) && isPalindrome[i + 1][j - 1]);
				if (isPalindrome[i][j] == true)
					matrix[i][j] = 0;
				else {
						matrix[i][j]= 99999;
					for (int k = i; k < j; k++) {
						int min = matrix[i][k] + matrix[k+1][j];
						if(matrix[i][j] > min + 1)
							matrix[i][j]=min + 1;
					}
				}
			}
		}
		return matrix[0][length-1];
	}
}
