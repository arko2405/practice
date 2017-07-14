package practice.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmicCrush {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			Integer n = sc.nextInt();
			long m = sc.nextLong();
			long arr[] = new long[n];
			long max = Long.MIN_VALUE;
			long x = 0;
			for (int i = 1; i <= m; i++) {
				Integer a = sc.nextInt();
				Integer b = sc.nextInt();
				long k = sc.nextLong();
				
				arr[a-1] += k;
				if(b < n)
					arr[b]-=k;
				
//				for(int j = a-1 ; j<b;j++){
//					arr[j]+=k;
//					max = Math.max(max, arr[j]);
//				}
			}
			for (int j = 0; j < arr.length; j++) {
				x=x+arr[j];
			    if(max<x) 
			    	max=x;
			}
			
			System.out.println(max);
		}
	

	}

}
/*
 
 https://www.hackerrank.com/challenges/crush
 
 Russian

You are given a list of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list. For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).

Input Format

First line will contain two integers  and  separated by a single space.
Next  lines will contain three integers ,  and  separated by a single space.
Numbers in list are numbered from  to .

Constraints






Output Format

A single line containing maximum value in the updated list.

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
Explanation

After first update list will be 100 100 0 0 0. 
After second update list will be 100 200 100 100 100.
After third update list will be 100 200 200 200 100.
So the required answer will be 200.
 
 * */
