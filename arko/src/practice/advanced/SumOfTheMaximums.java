package practice.advanced;

import java.util.Scanner;

public class SumOfTheMaximums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Integer n = sc.nextInt();
			Integer m = sc.nextInt();
			long inp[] = new long[n+1];
			for (int i = 1; i <= n; i++) {
				inp[i]=sc.nextLong();
			}
			long maxSum[][] = new long[n+1][n+1];
			long max[][] = new long[n+1][n+1];
			long calculated[][] = new long[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				maxSum[i][i]=inp[i];
				max[i][i]=inp[i];
				calculated[i][i]=1;
			}
			int startX = 1;
			int offSetY = 1 ;
			while(m-->0){
				int l = sc.nextInt();
				int r = sc.nextInt();
				if(calculated[l][r]==1)
					System.out.println(maxSum[l][r]);
				else{
					for (int j = offSetY; j <= n; j++) {
						for (int i = startX; i <= n-j; i++) {
							int y = i + j;
							max[i][y]=Math.max(max[i][y-1], inp[y]);
							maxSum[i][y] = maxSum[i][y-1]+maxSum[i+1][y]-maxSum[i+1][y-1]+max[i][y];
							calculated[i][y] = 1;
							if(i==l && y==r){
								System.out.println(maxSum[l][r]);
								offSetY = j;
								startX = i;
								j = n+1;
								break;
							}
							startX = 1;
						}
					}
				}
			}
		}
	}

}
/*

Alexey is playing with an array, , of  integers. His friend, Ivan, asks him to calculate the sum of the maximum values for all subsegments of . More formally, he wants Alexey to find .

Alexey solved Ivan's challenge faster than expected, so Ivan decides to add another layer of difficulty by having Alexey answer  queries. The  query contains subsegment , and he must calculate the sum of maximum values on all subsegments inside subsegment .

More formally, for each query , Alexey must calculate the following function:

.

Can you help Alexey solve this problem?

Input Format

The first line contains  space-separated positive integers,  (the length of array ) and  (number of queries), respectively. 
The second line contains  space-separated integers,  describing each element  (where ) in array . 
Each of the  subsequent lines contains  space-separated positive integers describing the respective values for  and  in query  (where ).

Constraints




Output Format

For each query  (where ), print its answer on a new line.

Sample Input

3 6
1 3 2
1 1
1 2
1 3
2 2
2 3
3 3
Sample Output

1
7
15
3
8
2
Explanation

The answer for the second query is shown below:  

The answer for the third query is shown below:  

*/