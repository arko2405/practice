package practice.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// quest : https://www.hackerrank.com/challenges/candies
public class Candies {

	public static void main(String[] args) {
		//usingDP();
		usingSimpleArrayTraversal();
	}

	private static void usingSimpleArrayTraversal() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
				int n = sc.nextInt();
				long rating[] = new long[n];
				long candies[] = new long[n];
				for (int i = 0; i < n; i++) {
					rating[i] = sc.nextLong();
				}
				candies[0]=1;
				for (int i = 1; i < rating.length; i++) {
					if(rating[i] > rating[i-1])
						candies[i] = candies[i-1]+1;
					else
						candies[i] = 1;
				}
				for (int i = n-2; i >= 0; i--) {
					if(rating[i] > rating[i+1])
						candies[i] = Math.max(candies[i], candies[i+1]+1);
				}
				long sum = 0;
				for(int i = 0;i < n; i++)sum+= candies[i];
				System.out.println(sum);
			}
		
	}

	private static void usingDP() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
				int n = sc.nextInt();
				long ra[] = new long[n];
				long dp[] = new long[n];
				for (int i = 0; i < n; i++) {
					ra[i] = sc.nextLong();
				}
				dp[0]=1;
				for(int i=1; i < n; i++){
				    if( ra[i] > ra[i-1] )
				        dp[i] = dp[i-1] + 1;
				    else if( dp[i-1] == 1 ){
				        dp[i] = 1;
				        for( int j=i-1; j>=0; j-- )
				            if( ra[j] > ra[j+1] )
				                dp[j] = Math.max( dp[j+1] + 1, dp[j] );
				            else
				                break;
				    }       
				    else
				        dp[i] = 1;
				}
				long sum = 0;
				for(int i = 0;i < n; i++)sum+= dp[i];
				System.out.println(sum);
				
			}
		
	}

}
/*

Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line ( their positions are fixed), and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies given to the children.

Input Format

The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an integer that indicates the rating of each child.

Constraints



Output Format

Output a single line containing the minimum number of candies Alice must buy.

Sample Input

3  
1  
2  
2
Sample Output

4
Explanation

Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies. Hence optimal distribution will be 1, 2, 1.

*/