package practice.stackproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int n3 = sc.nextInt();
				int arr[] = new int[n1];
				Stack<Integer> st1 = new Stack<>();
				Stack<Integer> st2 = new Stack<>();
				Stack<Integer> st3 = new Stack<>();
				Map<Integer, Boolean> mp2 = new HashMap<>();
				Map<Integer, Boolean> mp3 = new HashMap<>();
				Map<Integer, Boolean> mp1 = new HashMap<>();
				for (int j = 0; j < arr.length; j++) {
					arr[j] = sc.nextInt();
				}
				st1.push(arr[arr.length - 1]);
				mp1.put(st1.peek(), true);
				for (int j = arr.length - 2; j >= 0; j--) {
					st1.push(st1.peek() + arr[j]);
					mp1.put(st1.peek(), true);
				}
				arr =new int [n2];
				for (int j = 0; j < arr.length; j++) {
					arr[j] = sc.nextInt();
				}
				st2.push(arr[arr.length - 1]);
				mp2.put(st2.peek(), true);
				for (int j = arr.length - 2; j >= 0; j--) {
					st2.push(st2.peek() + arr[j]);
					mp2.put(st2.peek(), true);
				}
				arr =new int [n3];
				for (int j = 0; j < arr.length; j++) {
					arr[j] = sc.nextInt();
				}
				st3.push(arr[arr.length - 1]);
				mp3.put(st3.peek(), true);
				for (int j = arr.length - 2; j >= 0; j--) {
					st3.push(st3.peek() + arr[j]);
					mp3.put(st3.peek(), true);
				}
				Stack<Integer> st = null;
				Map<Integer, Boolean> m1 = null;
				Map<Integer, Boolean> m2 = null;
				if(st1.peek()<st2.peek()){
					st = st1;
				}else{
					st = st2;
				}
				if(st.peek()>st3.peek()){
					st = st3;
				}
				if(st==st1){
					m1 = mp2;
					m2 = mp3;
				}else if(st==st2){
					m1 = mp1;
					m2 = mp3;
				}else{
					m1 = mp1;
					m2 = mp2;
				}
				int hgt = 0;
				while(!st.isEmpty()){
					int temp = st.pop();
					if(m1.containsKey(temp) && m2.containsKey(temp)){
						hgt = temp;
						break;
					}
				}
				System.out.println(hgt);
				
			}

	}

}
/*

You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

Note: An empty stack is still a stack.

Input Format

The first line contains three space-separated integers, , , and , describing the respective number of cylinders in stacks , , and . The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

The second line contains  space-separated integers describing the cylinder heights in stack .
The third line contains  space-separated integers describing the cylinder heights in stack .
The fourth line contains  space-separated integers describing the cylinder heights in stack .
Constraints



Output Format

Print a single integer denoting the maximum height at which all stacks will be of equal height.

Sample Input

5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
Sample Output

5

*/