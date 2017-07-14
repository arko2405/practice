package practice.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// quest : https://www.hackerrank.com/challenges/mandragora?h_r=next-challenge&h_v=zen
public class MandragoraForest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int t = sc.nextInt();
			while(t-->0){
				long n = sc.nextInt();
				List<Long> arr = new ArrayList<>();
				long sum = 0;
				for (int i = 0; i < n; i++) {
					long inp = sc.nextLong();
					arr.add(inp);
					sum += inp;
				}
				Collections.sort(arr);
				long p = sum;
				long s = 2;
				sum = sum - arr.get(0);
				int i = 1;
				while(i<n){
					if(s*sum < p)
						break;
					p = s*sum;
					sum = sum - arr.get(i);
					s++;
					i++;
				}
				System.out.println(p);
			}
			
		}

	}


}
/*

The evil forest is guarded by  vicious mandragoras. Each  mandragora has  health points ().

Garnet and her pet begin their journey through the evil forest with  strength points and  experience points. For each undefeated mandragora , she can perform either of the following actions:

Garnet's pet eats mandragora . This increments  by  and defeats mandragora .
Garnet's pet battles mandragora . This increases  by  experience points and defeats mandragora .
Each mandragora can only be defeated once, and Garnet can defeat the mandragoras in any order. Given the respective health points for each mandragora, can you find the maximum number of experience points she can earn from defeating all  mandragoras?

Input Format

The first line contains an integer, , denoting the number of test cases. Each test case is described over two lines:

The first line contains a single integer, , denoting the number of mandragoras in the forest.
The second line contains  space-separated integers describing the respective health points for the mandragoras (i.e., ).
Constraints



, where 
The sum of all s in a single test case is 
Output Format

For each test case, print a single line with an integer denoting the maximum number of experience points that Garnet can earn.

Sample Input

1
3
3 2 2
Sample Output

10 
Explanation

There are  mandragoras having the following health points: . Initially,  and . The following is an optimal sequence of actions for achieving the maximum number of experience points possible:

Eat the second mandragora ().  is increased from  to , and  is still .
Battle the first mandragora ().  remains the same, but  increases by  experience points.
Battle the third mandragora ().  remains the same, but  increases by  experience points.
Garnet earns  experience points, so we print  on a new line.

*/