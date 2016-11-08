package practice.interviewquestions;

public class LargestProductOfLengthsOf2NonOverlappingPalindromicSubSeqOfAStrong {

	public static void main(String[] args) {
		String _s = "axbawbaseksqke";
		int res = funPal(_s);
		System.out.println(res);

	}

	private static int funPal(String s) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length()-1; i++) {
			String first = s.substring(0, i+1);
			String second = s.substring(i+1);
			int l1 = largestPalindromeIn(first);
			int l2 = largestPalindromeIn(second);
			max = Math.max(max, l1*l2);
		}
		return max;
	}

	private static int largestPalindromeIn(String seq) {
		int n = seq.length();
	       int i, j, cl;
	       int L[][] = new int[n][n];
	      
	       for (i = 0; i < n; i++)
	           L[i][i] = 1;
	              
	        for (cl=2; cl<=n; cl++)
	        {
	            for (i=0; i<n-cl+1; i++)
	            {
	                j = i+cl-1;
	                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
	                   L[i][j] = 2;
	                else if (seq.charAt(i) == seq.charAt(j))
	                   L[i][j] = L[i+1][j-1] + 2;
	                else
	                   L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
	            }
	        }
	              
	        return L[0][n-1];
	}

}
