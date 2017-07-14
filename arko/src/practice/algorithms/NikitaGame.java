package practice.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// question : https://www.hackerrank.com/challenges/array-splitting
public class NikitaGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int t = sc.nextInt();
			while(t-->0){
				int n = sc.nextInt();
				double arr[] = new double[n];
				Map<Double, List<Integer>> sumMap = new HashMap<>();
				Double prev = 0.0 ;
				for (int i = 0; i < arr.length; i++) {
					arr[i] =  sc.nextLong();
					prev += arr[i];
					if(!sumMap.containsKey(prev)){
						List<Integer> indexes = new ArrayList<>();
						indexes.add(i);
						sumMap.put(prev, indexes);
					}else
						sumMap.get(prev).add(i);
				}
				System.out.println(noOfPointScored(arr,sumMap,0,n-1,0.0,prev));
			}
			
		}

	}

	private static int noOfPointScored(double[] arr,Map<Double, List<Integer>> sumMap, int left, int right,
			Double sumTillFirst, Double sumTillLast) {
		
		List<Integer> indexes = sumMap.get(sumTillFirst+ (sumTillLast-sumTillFirst)/2);
		if(indexes!=null && left<right){
			int max = -1;
			for (int i = 0; i < indexes.size(); i++) {
				int index = indexes.get(i);
				if(index>=left && index<right){
					int pointsFromLeft = noOfPointScored(arr,sumMap, left, index, sumTillFirst,sumTillFirst+(sumTillLast-sumTillFirst)/2);
					int pointsFromRight = noOfPointScored(arr,sumMap, index+1, right, sumTillFirst+(sumTillLast-sumTillFirst)/2, sumTillLast);
					int currMax = Math.max(pointsFromLeft, pointsFromRight);
					max = Math.max(max, currMax);
					break;
				}
			}
			return 1+max;
		}
		return 0;
	}

}
/*

Nikita just came up with a new array game. The rules are as follows:

Initially, there is an array, , containing  integers.

In each move, Nikita must partition the array into  non-empty parts such that the sum of the elements in the left partition is equal to the sum of the elements in the right partition. If Nikita can make such a move, she gets  point; otherwise, the game ends.

After each successful move, Nikita discards either the left partition or the right partition and continues playing by using the remaining partition as array .

Nikita loves this game and wants your help getting the best score possible. Given , can you find and print the maximum number of points she can score?

Input Format

The first line contains an integer, , denoting the number of test cases. Each test case is described over  lines in the following format:

A line containing a single integer, , denoting the size of array .
A line of  space-separated integers describing the elements in array .
Constraints




Scoring

 for  of the test data
 for  of the test data
 for  of the test data
Output Format

For each test case, print Nikita's maximum possible score on a new line.

Sample Input

3
3
3 3 3
4
2 2 2 2
7
4 1 0 1 1 0 1
Sample Output

0
2
3
Explanation

Test Case 0:

Nikita cannot partition  into  parts having equal sums. Therefore, her maximum possible score is  and we print  on a new line.

Test Case 1:

Initially,  looks like this: 
split(3).png

She splits the array into  partitions having equal sums, and then discards the left partition:

split(1).png

She then splits the new array into  partitions having equal sums, and then discards the left partition:

split(2).png

At this point the array only has  element and can no longer be partitioned, so the game ends. Because Nikita successfully split the array twice, she gets  points and we print  on a new line.

*/