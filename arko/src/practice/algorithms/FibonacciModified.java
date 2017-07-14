package practice.algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			BigInteger t1 = sc.nextBigInteger();
			BigInteger t2 = sc.nextBigInteger();
			int n = sc.nextInt();
			BigInteger arr[] = new BigInteger[n+1];
			arr[1] = t1;
			arr[2] = t2;
			for (int i = 3; i <= n; i++) {
				arr[i] = arr[i-2].add(arr[i-1].multiply(arr[i-1]));
			}
			System.out.println(arr[n]);
		}

	}

}
/*

We define a modified Fibonacci sequence using the following definition:

Given terms  and  where , term  is computed using the following relation:

For example, if term  and , term , term , term , and so on.
t(i+2) = t(i) + t(i+1)^2

Given three integers, , , and , compute and print term  of a modified Fibonacci sequence.

Note: The value of  may exceed the range of a -bit integer. Many submission languages have libraries that can handle such large results but, for those that don't (e.g., C++), you will need to be more creative in your solution to compensate for the limitations of your chosen submission language.

Input Format

A single line of three space-separated integers describing the respective values of , , and .

Constraints



 may exceed the range of a -bit integer.
Output Format

Print a single integer denoting the value of term  in the modified Fibonacci sequence where the first two terms are  and .

Sample Input

0 1 5
Sample Output

5
Explanation

The first two terms of the sequence are  and , which gives us a modified Fibonacci sequence of . Because , we print term , which is .

*/