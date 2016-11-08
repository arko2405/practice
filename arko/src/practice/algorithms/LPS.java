package practice.algorithms;

public class LPS {
	static String seq = "GEEKS FOR GEEKS";

	public static void main(String[] args) {
		System.out.println(longestPalindrome());
	}

	private static int longestPalindrome() {
		int length = seq.length();
		int ans[][] = new int[length][length];
		for (int i = 0; i < length; i++) {
			ans[i][i]=1;
		}
		
		for (int l = 1; l < length; l++) {
			for (int i = 0; i < length-l; i++) {
				int j = i + l;
				if(seq.charAt(i)==seq.charAt(j) && l==2)
					ans[i][j]=2;
				else if(seq.charAt(i)==seq.charAt(j))
					ans[i][j]= 2 + ans[i+1][j-1];
				else
					ans[i][j] = Math.max(ans[i][j-1], ans[i+1][j]);
			}
		}
		return ans[0][length - 1];
	}
}
