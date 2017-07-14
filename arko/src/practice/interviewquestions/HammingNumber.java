package practice.interviewquestions;

import java.util.Scanner;
// question see below
public class HammingNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int hamming[] = new int[10];
			int n = sc.nextInt();
			hamming[0] = 1;
			int calculatedTill = 0;
			System.out.println(getNthHammingNumber(n, hamming, calculatedTill));
			for (int i = 0; i < hamming.length; i++) {
				System.out.print(hamming[i]+ "  ");
			}
		}
	}

	private static int getNthHammingNumber(int n, int[] hamming, int calculatedTill) {
	    int i2 = 0, i3 = 0, i5 = 0;
	    int i;
	    int nextMultipleOf2 = 2;
	    int nextMultipleOf3 = 3;
	    int nextMultipleOf5 = 5;
	    int nextHammingNo = 1;
	    if(n<=calculatedTill-1)
	    	return hamming[n-1];
	    for(i=calculatedTill+1; i<n; i++)
	    {
	       nextHammingNo = min(nextMultipleOf2,nextMultipleOf3,nextMultipleOf5);
	       hamming[i] = nextHammingNo;                    
	       if(nextHammingNo == nextMultipleOf2)
	       {
	           i2 = i2+1;       
	           nextMultipleOf2 = hamming[i2]*2;
	       }
	       if(nextHammingNo == nextMultipleOf3)
	       {
	           i3 = i3+1;
	           nextMultipleOf3 = hamming[i3]*3;
	       }
	       if(nextHammingNo == nextMultipleOf5)
	       {
	           i5 = i5+1;
	           nextMultipleOf5 = hamming[i5]*5;
	       }
	    }
	    calculatedTill = n-1;
	    return nextHammingNo;
	}

	private static int min(int a, int b, int c) {
		if (a <= b) {
			if (a <= c)
				return a;
			else
				return c;
		}
		if (b <= c)
			return b;
		else
			return c;
	}

}
/*

Hamming Number
Max. Marks 100
Hamming number are those number which are in form of 2^i * 3^j * 5^k where i>=j>=k>=0.
Hamming Sequence : 
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16
Input: Input contains a single integer N.
Output:
Print Nth Hamming number of sequence.
Constraints:
1<= N <=1000
Sample Input
(Plaintext Link)
7 
Sample Output
(Plaintext Link)
8

*/
