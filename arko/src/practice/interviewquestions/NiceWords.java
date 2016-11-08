package practice.interviewquestions;

import java.util.Scanner;

//question see below
public class NiceWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int t = sc.nextInt();
			int arr[][][] = new int[65][65][65];
			arr[0][0][0]=1;
			int calculatedTill = 0;
			while(t-->0){
				int n = sc.nextInt();
				if(n<=calculatedTill)
					System.out.println(arr[n][n][n]);
				else{
					getNoOfNiceWordsUsingDP(n,n,n,arr,calculatedTill+1);
					System.out.println(arr[n][n][n]);
				}
				calculatedTill = n;
			}
		}

	}

	private static void getNoOfNiceWordsUsingDP(int noOfALeft, int noOfQLeft, int noOfFLeft, int[][][] arr,int start) {
		for (int i = 0; i <= noOfALeft; i++) {
			for (int j = i; j <= noOfQLeft; j++) {
				for (int k = start<j?j:start; k <= noOfFLeft; k++) {
					if(k == 0){
						arr[i][j][k] = 1 ;
					}
					else if(j == 0)
						arr[i][j][k] = arr[i][j][k-1];
					else if(i == 0){
						if(j < k)
							arr[i][j][k] =  arr[i][j][k-1] + arr[i][j-1][k];
						else
							arr[i][j][k] = arr[i][j-1][k];
					}
					else{
					arr[i][j][k] = arr[i][j][k] + arr[i-1][j][k];
					if(i < j)
						arr[i][j][k] = arr[i][j][k] + arr[i][j-1][k];
					if(j<k)
						arr[i][j][k] = arr[i][j][k] + arr[i][j][k-1];
					}
				}
				
			}
			
		}
	}

	private static long getNoOfNiceWords(long noOfALeft, long noOfQLeft, long noOfFLeft) {
		if(noOfFLeft == 0){
			return 1 ;
		}
		if(noOfQLeft == 0)
			return getNoOfNiceWords(0, 0, noOfFLeft-1);
		if(noOfALeft == 0){
			if(noOfQLeft < noOfFLeft)
				return getNoOfNiceWords(0, noOfQLeft, noOfFLeft-1) + getNoOfNiceWords(0, noOfQLeft-1, noOfFLeft);
			else
				return getNoOfNiceWords(0, noOfQLeft-1, noOfFLeft);
		}
		long sum = 0;
		sum = sum + getNoOfNiceWords(noOfALeft-1, noOfQLeft, noOfFLeft);
		if(noOfALeft < noOfQLeft)
			sum = sum + getNoOfNiceWords(noOfALeft, noOfQLeft-1, noOfFLeft);
		if(noOfQLeft<noOfFLeft)
			sum = sum + getNoOfNiceWords(noOfALeft, noOfQLeft, noOfFLeft-1);
		return sum;
	}

}
/*

Nice Words
Max. Marks 100
Once upon a time, there was a little boy, his name was Neo. Neo was playing with his favourite alphabets {A,Q,F},he started constructing words of length 3*Nbut he likes only Nice words.
Nice word is defined as: A word W in which following condition holds
i) n(A,W) = n(Q,W) = n(F,W) where n(L,W) = number of occurrences of letter L in string W
ii) For any prefix P of word W, number of occurrences of A must be greater than or equal to number of occurrences of Q and number of occurrences of Q must be greater than or equal to number of occurrences of F.
i.e n(A,P) >= n(Q,P) >= n(F,P)
For Ex: If N = 2 there are 5 NICE words: AAQQFF , AAQFQF , AQAQFF , AQAFQF and AQFAQF .
For Given N , He wants to know number of Nice words of length 3*N that consists of {A,Q,F} letters.
Input:
The first line of input consists of an integer T , indicating the number of test cases. For each test case, there will be one integer N as the description.
Output:
For each test case, output an integer indicating number of NICE words.
Constraints:
1 <= T <= 105
0 <= N <= 64
Sample Input
(Plaintext Link)
3 1 2 5
Sample Output
(Plaintext Link)
1 5 6006
Explanation
case n=1: there is only 1 possible nice word : AQF
case n=2: there are 5 possible nice words: AAQQFF , AAQFQF , AQAQFF , AQAFQF and AQFAQF .

*/